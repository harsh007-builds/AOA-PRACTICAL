import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {
    static void quickSort(int[] a, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(a, low, high);
            quickSort(a, low, pivotIndex - 1);
            quickSort(a, pivotIndex + 1, high);
        }
    }
    static int partition(int[] a, int low, int high) {
        int pivot = a[high], i = low - 1;
        for (int j = low; j < high; j++) {
            if (a[j] <= pivot) {
                i++;
                int temp = a[i]; a[i] = a[j]; a[j] = temp;
            }
        }
        int temp = a[i + 1]; a[i + 1] = a[high]; a[high] = temp;
        return i + 1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of elements: ");
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) { System.out.print("Element: "); a[i] = sc.nextInt(); }
        long start = System.nanoTime();
        quickSort(a, 0, n - 1);
        long end = System.nanoTime();
        System.out.println("Sorted array: " + Arrays.toString(a));
        System.out.println("Execution time: " + (end - start) + " ns");
        System.out.println("Time complexity: Best/Average O(n log n), Worst O(n^2); Space: O(log n) average recursion.");
    }
}
