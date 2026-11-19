import java.util.Scanner;

public class RecursionTreeMethod {
    // Analyzes T(n) = aT(n/b) + c*n^k using recursion-tree level costs.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a (number of subproblems): ");
        double a = sc.nextDouble();
        System.out.print("Enter b (input-size division factor, > 1): ");
        double b = sc.nextDouble();
        System.out.print("Enter c (coefficient of n^k): ");
        double c = sc.nextDouble();
        System.out.print("Enter k (power in f(n) = c*n^k): ");
        double k = sc.nextDouble();
        System.out.print("Enter n: ");
        int n = sc.nextInt();

        if (a < 1 || b <= 1 || c < 0 || k < 0 || n < 1) {
            System.out.println("Invalid input.");
            return;
        }

        long start = System.nanoTime();
        double logN = Math.log(n) / Math.log(b);
        int levels = (int)Math.floor(logN) + 1;
        double total = 0;
        System.out.println("\nLevel-wise cost:");
        for (int i = 0; i < levels; i++) {
            double subproblemSize = n / Math.pow(b, i);
            double levelCost = Math.pow(a, i) * c * Math.pow(subproblemSize, k);
            total += levelCost;
            System.out.printf("Level %d: %.4f%n", i, levelCost);
        }
        double leaves = Math.pow(a, logN);
        System.out.printf("Approximate number of leaves: %.4f%n", leaves);
        System.out.printf("Sum of internal-level costs: %.4f%n", total);
        double p = Math.log(a) / Math.log(b);
        System.out.println("Compare k with log_b(a) = " + p);
        if (Math.abs(k - p) < 1e-9)
            System.out.println("Expected order: Theta(n^k log n)");
        else if (k > p)
            System.out.println("Expected order: Theta(n^k)");
        else
            System.out.println("Expected order: Theta(n^(log_b a))");
        long end = System.nanoTime();
        System.out.println("Execution time: " + (end - start) + " ns");
        System.out.println("Time complexity of analysis program: O(log_b n)");
    }
}
