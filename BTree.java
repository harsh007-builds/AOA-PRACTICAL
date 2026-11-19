import java.util.Scanner;

public class BTree {
    static class Node {
        int[] keys;
        Node[] child;
        int count;
        boolean leaf;
        Node(int t, boolean leaf) {
            keys = new int[2 * t - 1];
            child = new Node[2 * t];
            this.leaf = leaf;
        }
    }

    static class Tree {
        int t;
        Node root;
        Tree(int t) { this.t = t; root = new Node(t, true); }

        void traverse(Node x) {
            int i;
            for (i = 0; i < x.count; i++) {
                if (!x.leaf) traverse(x.child[i]);
                System.out.print(x.keys[i] + " ");
            }
            if (!x.leaf) traverse(x.child[i]);
        }

        boolean search(Node x, int key) {
            int i = 0;
            while (i < x.count && key > x.keys[i]) i++;
            if (i < x.count && x.keys[i] == key) return true;
            return !x.leaf && search(x.child[i], key);
        }

        void insert(int key) {
            Node r = root;
            if (r.count == 2 * t - 1) {
                Node s = new Node(t, false);
                root = s;
                s.child[0] = r;
                split(s, 0, r);
                insertNonFull(s, key);
            } else insertNonFull(r, key);
        }

        void split(Node parent, int index, Node full) {
            Node right = new Node(t, full.leaf);
            right.count = t - 1;
            for (int j = 0; j < t - 1; j++) right.keys[j] = full.keys[j + t];
            if (!full.leaf)
                for (int j = 0; j < t; j++) right.child[j] = full.child[j + t];
            full.count = t - 1;
            for (int j = parent.count; j >= index + 1; j--)
                parent.child[j + 1] = parent.child[j];
            parent.child[index + 1] = right;
            for (int j = parent.count - 1; j >= index; j--)
                parent.keys[j + 1] = parent.keys[j];
            parent.keys[index] = full.keys[t - 1];
            parent.count++;
        }

        void insertNonFull(Node x, int key) {
            int i = x.count - 1;
            if (x.leaf) {
                while (i >= 0 && key < x.keys[i]) {
                    x.keys[i + 1] = x.keys[i]; i--;
                }
                if (i >= 0 && x.keys[i] == key) return;
                x.keys[i + 1] = key;
                x.count++;
            } else {
                while (i >= 0 && key < x.keys[i]) i--;
                i++;
                if (x.child[i].count == 2 * t - 1) {
                    split(x, i, x.child[i]);
                    if (key > x.keys[i]) i++;
                    else if (key == x.keys[i]) return;
                }
                insertNonFull(x.child[i], key);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter minimum degree t (>= 2): ");
        int t = sc.nextInt();
        if (t < 2) { System.out.println("t must be >= 2"); return; }
        Tree tree = new Tree(t);
        System.out.print("How many keys? ");
        int n = sc.nextInt();
        int[] values = new int[n];
        for (int i = 0; i < n; i++) { System.out.print("Key: "); values[i] = sc.nextInt(); }
        long start = System.nanoTime();
        for (int x : values) tree.insert(x);
        long end = System.nanoTime();
        System.out.print("B-Tree traversal: ");
        tree.traverse(tree.root);
        System.out.println("\nExecution time (insertion): " + (end - start) + " ns");
        System.out.println("Insertion: O(log n) per key; all keys: O(n log n). Search: O(log n).");
        System.out.print("Search key: ");
        int key = sc.nextInt();
        long s = System.nanoTime();
        boolean found = tree.search(tree.root, key);
        long e = System.nanoTime();
        System.out.println(found ? "Key found" : "Key not found");
        System.out.println("Search execution time: " + (e - s) + " ns");
    }
}
