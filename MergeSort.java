import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
    static void mergeSort(int[] a, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSort(a, left, mid);
        mergeSort(a, mid + 1, right);
        merge(a, left, mid, right);
    }
    static void merge(int[] a, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right)
            temp[k++] = (a[i] <= a[j]) ? a[i++] : a[j++];
        while (i <= mid) temp[k++] = a[i++];
        while (j <= right) temp[k++] = a[j++];
        for (i = 0; i < temp.length; i++) a[left + i] = temp[i];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of elements: ");
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) { System.out.print("Element: "); a[i] = sc.nextInt(); }
        long start = System.nanoTime();
        mergeSort(a, 0, n - 1);
        long end = System.nanoTime();
        System.out.println("Sorted array: " + Arrays.toString(a));
        System.out.println("Execution time: " + (end - start) + " ns");
        System.out.println("Time complexity: Best/Average/Worst O(n log n); Space: O(n).");
    }
}
