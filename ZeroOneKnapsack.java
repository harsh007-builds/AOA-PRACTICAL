import java.util.Scanner;

public class ZeroOneKnapsack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of items: ");
        int n = sc.nextInt();
        int[] weight = new int[n], value = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Weight and value: ");
            weight[i] = sc.nextInt(); value[i] = sc.nextInt();
        }
        System.out.print("Capacity: ");
        int capacity = sc.nextInt();
        long start = System.nanoTime();
        int[][] dp = new int[n + 1][capacity + 1];
        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                dp[i][w] = dp[i - 1][w];
                if (weight[i - 1] <= w)
                    dp[i][w] = Math.max(dp[i][w],
                            value[i - 1] + dp[i - 1][w - weight[i - 1]]);
            }
        }
        long end = System.nanoTime();
        System.out.println("Maximum value: " + dp[n][capacity]);
        System.out.println("Execution time: " + (end - start) + " ns");
        System.out.println("Time complexity: O(n * capacity); Space: O(n * capacity).");
    }
}
