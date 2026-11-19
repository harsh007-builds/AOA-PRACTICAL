import java.util.Scanner;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("First string: ");
        String a = sc.nextLine();
        System.out.print("Second string: ");
        String b = sc.nextLine();

        long start = System.nanoTime();
        int m = a.length(), n = b.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        StringBuilder lcs = new StringBuilder();
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (a.charAt(i - 1) == b.charAt(j - 1)) {
                lcs.append(a.charAt(i - 1)); i--; j--;
            } else if (dp[i - 1][j] >= dp[i][j - 1]) i--;
            else j--;
        }
        lcs.reverse();
        long end = System.nanoTime();
        System.out.println("LCS: " + lcs);
        System.out.println("LCS length: " + dp[m][n]);
        System.out.println("Execution time: " + (end - start) + " ns");
        System.out.println("Time complexity: O(m * n); Space: O(m * n).");
    }
}
