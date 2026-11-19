import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class JobSequencing {
    static class Job {
        String id; int deadline, profit;
        Job(String id, int deadline, int profit) {
            this.id = id; this.deadline = deadline; this.profit = profit;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of jobs: ");
        int n = sc.nextInt();
        Job[] jobs = new Job[n];
        int maxDeadline = 0;
        for (int i = 0; i < n; i++) {
            System.out.print("Job ID, deadline, profit: ");
            String id = sc.next(); int d = sc.nextInt(), p = sc.nextInt();
            jobs[i] = new Job(id, d, p);
            maxDeadline = Math.max(maxDeadline, d);
        }
        long start = System.nanoTime();
        Arrays.sort(jobs, Comparator.comparingInt((Job j) -> j.profit).reversed());
        String[] slots = new String[maxDeadline + 1];
        int totalProfit = 0;
        for (Job job : jobs) {
            for (int t = Math.min(job.deadline, maxDeadline); t >= 1; t--) {
                if (slots[t] == null) {
                    slots[t] = job.id;
                    totalProfit += job.profit;
                    break;
                }
            }
        }
        long end = System.nanoTime();
        System.out.println("Scheduled jobs:");
        for (int t = 1; t < slots.length; t++)
            if (slots[t] != null) System.out.println("Slot " + t + ": " + slots[t]);
        System.out.println("Maximum profit: " + totalProfit);
        System.out.println("Execution time: " + (end - start) + " ns");
        System.out.println("Time complexity: O(n log n + nD), where D is maximum deadline.");
    }
}
