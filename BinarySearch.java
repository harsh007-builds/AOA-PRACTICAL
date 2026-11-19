import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    static int binarySearch(int[] a, int key) {
        int low = 0, high = a.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] == key) return mid;
            if (a[mid] < key) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of elements: ");
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) { System.out.print("Element: "); a[i] = sc.nextInt(); }
        Arrays.sort(a);
        System.out.println("Sorted array: " + Arrays.toString(a));
        System.out.print("Enter key to search: ");
        int key = sc.nextInt();
        long start = System.nanoTime();
        int index = binarySearch(a, key);
        long end = System.nanoTime();
        System.out.println(index >= 0 ? "Found at sorted index " + index : "Not found");
        System.out.println("Execution time: " + (end - start) + " ns");
        System.out.println("Time complexity: Best O(1), Average/Worst O(log n); Space: O(1).");
    }
}
