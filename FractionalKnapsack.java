import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class FractionalKnapsack {
    static class Item {
        double value, weight;
        Item(double value, double weight) { this.value = value; this.weight = weight; }
        double ratio() { return value / weight; }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of items: ");
        int n = sc.nextInt();
        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Value and weight: ");
            double v = sc.nextDouble(), w = sc.nextDouble();
            items[i] = new Item(v, w);
        }
        System.out.print("Knapsack capacity: ");
        double capacity = sc.nextDouble();
        long start = System.nanoTime();
        Arrays.sort(items, Comparator.comparingDouble(Item::ratio).reversed());
        double totalValue = 0, remaining = capacity;
        for (Item item : items) {
            if (remaining <= 0) break;
            double take = Math.min(1.0, remaining / item.weight);
            totalValue += take * item.value;
            remaining -= take * item.weight;
        }
        long end = System.nanoTime();
        System.out.printf("Maximum value: %.2f%n", totalValue);
        System.out.println("Execution time: " + (end - start) + " ns");
        System.out.println("Time complexity: O(n log n) due to sorting; Space: O(1) auxiliary (excluding sort).");
    }
}
