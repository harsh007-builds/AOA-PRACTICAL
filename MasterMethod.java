import java.util.Scanner;

public class MasterMethod {
    // Classifies T(n) = aT(n/b) + c*n^k using the Master Theorem.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a (number of subproblems): ");
        double a = sc.nextDouble();
        System.out.print("Enter b (division factor, > 1): ");
        double b = sc.nextDouble();
        System.out.print("Enter c (coefficient of n^k): ");
        double c = sc.nextDouble();
        System.out.print("Enter k (power in f(n) = c*n^k): ");
        double k = sc.nextDouble();
        System.out.print("Enter n for timing: ");
        int n = sc.nextInt();

        if (a < 1 || b <= 1 || c <= 0 || k < 0 || n < 1) {
            System.out.println("Invalid input.");
            return;
        }

        long start = System.nanoTime();
        double p = Math.log(a) / Math.log(b);
        System.out.println("\nRecurrence: T(n) = " + a + "T(n/" + b + ") + " + c + "n^" + k);
        System.out.println("log_b(a) = " + p);

        if (k < p - 1e-9) {
            System.out.println("Case 1: f(n) is polynomially smaller.");
            System.out.println("Answer: Theta(n^(" + p + "))");
        } else if (Math.abs(k - p) <= 1e-9) {
            System.out.println("Case 2: f(n) matches n^(log_b a).");
            System.out.println("Answer: Theta(n^(" + p + ") log n)");
        } else {
            System.out.println("Case 3: f(n) is polynomially larger (regularity assumed).");
            System.out.println("Answer: Theta(n^" + k + ")");
        }

        // Small calculation makes the measured execution meaningful.
        double check = 0;
        for (int i = 1; i <= n; i++) check += Math.pow(i, k);
        System.out.println("Sample sum used for timing: " + check);
        long end = System.nanoTime();
        System.out.println("Execution time: " + (end - start) + " ns");
        System.out.println("Time complexity of classification: O(1); sample sum: O(n)");
    }
}
