import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BPlusTree {
    static class Node {
        boolean leaf;
        List<Integer> keys = new ArrayList<>();
        List<Node> children = new ArrayList<>();
        Node next;
        Node(boolean leaf) { this.leaf = leaf; }
    }

    static class Tree {
        int order; // Maximum children in an internal node
        Node root;
        Tree(int order) { this.order = order; root = new Node(true); }

        Node findLeaf(int key) {
            Node cur = root;
            while (!cur.leaf) {
                int i = 0;
                while (i < cur.keys.size() && key >= cur.keys.get(i)) i++;
                cur = cur.children.get(i);
            }
            return cur;
        }

        boolean search(int key) {
            Node leaf = findLeaf(key);
            return leaf.keys.contains(key);
        }

        void insert(int key) {
            Node leaf = findLeaf(key);
            int pos = 0;
            while (pos < leaf.keys.size() && leaf.keys.get(pos) < key) pos++;
            if (pos < leaf.keys.size() && leaf.keys.get(pos) == key) return;
            leaf.keys.add(pos, key);
            if (leaf.keys.size() >= order) splitLeaf(leaf);
        }

        void splitLeaf(Node leaf) {
            Node right = new Node(true);
            int mid = (leaf.keys.size() + 1) / 2;
            while (leaf.keys.size() > mid)
                right.keys.add(leaf.keys.remove(mid));
            right.next = leaf.next;
            leaf.next = right;
            insertInParent(leaf, right.keys.get(0), right);
        }

        void insertInParent(Node left, int separator, Node right) {
            if (left == root) {
                Node newRoot = new Node(false);
                newRoot.keys.add(separator);
                newRoot.children.add(left);
                newRoot.children.add(right);
                root = newRoot;
                return;
            }
            Node parent = findParent(root, left);
            int index = parent.children.indexOf(left);
            parent.keys.add(index, separator);
            parent.children.add(index + 1, right);
            if (parent.children.size() > order) splitInternal(parent);
        }

        Node findParent(Node current, Node target) {
            if (current.leaf) return null;
            for (Node child : current.children) {
                if (child == target) return current;
                Node result = findParent(child, target);
                if (result != null) return result;
            }
            return null;
        }

        void splitInternal(Node node) {
            int mid = node.keys.size() / 2;
            int promoted = node.keys.get(mid);
            Node right = new Node(false);

            for (int i = mid + 1; i < node.keys.size(); i++)
                right.keys.add(node.keys.get(i));
            for (int i = mid + 1; i < node.children.size(); i++)
                right.children.add(node.children.get(i));

            while (node.keys.size() > mid) node.keys.remove(node.keys.size() - 1);
            while (node.children.size() > mid + 1)
                node.children.remove(node.children.size() - 1);

            insertInParent(node, promoted, right);
        }

        void displayLeaves() {
            Node cur = root;
            while (!cur.leaf) cur = cur.children.get(0);
            System.out.print("B+ Tree leaf sequence: ");
            while (cur != null) {
                System.out.print(cur.keys + " ");
                cur = cur.next;
            }
            System.out.println();
        }

        void rangeSearch(int low, int high) {
            Node cur = findLeaf(low);
            while (cur != null) {
                for (int key : cur.keys) {
                    if (key >= low && key <= high) System.out.print(key + " ");
                    if (key > high) return;
                }
                cur = cur.next;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter order (maximum children, >= 3): ");
        int order = sc.nextInt();
        if (order < 3) { System.out.println("Order must be >= 3"); return; }
        Tree tree = new Tree(order);
        System.out.print("Number of keys: ");
        int n = sc.nextInt();
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Key: ");
            values[i] = sc.nextInt();
        }

        long start = System.nanoTime();
        for (int value : values) tree.insert(value);
        long end = System.nanoTime();
        tree.displayLeaves();
        System.out.println("Insertion execution time: " + (end - start) + " ns");
        System.out.println("Insertion: O(log n) per key; building n keys: O(n log n).");

        System.out.print("Search key: ");
        int key = sc.nextInt();
        long s = System.nanoTime();
        boolean found = tree.search(key);
        long e = System.nanoTime();
        System.out.println(found ? "Key found" : "Key not found");
        System.out.println("Search execution time: " + (e - s) + " ns");

        System.out.print("Range low and high: ");
        int low = sc.nextInt(), high = sc.nextInt();
        long rs = System.nanoTime();
        tree.rangeSearch(low, high);
        long re = System.nanoTime();
        System.out.println("\nRange query execution time: " + (re - rs) + " ns");
        System.out.println("Range search: O(log n + r), where r is the number of reported keys.");
    }
}
