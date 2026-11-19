# AOA Lab Experiments – Java

Standalone Java programs for all **11 experiments** in the Analysis of Algorithms (AOA) laboratory course. Each program accepts user input, executes the algorithm, prints the result, measures execution time using `System.nanoTime()`, and displays the relevant time and space complexities.

---

## Experiments

| # | File | Algorithm / Topic |
|---|------|-------------------|
| 1 | `RecursionTreeMethod.java` | Recursion Tree Method |
| 2 | `MasterMethod.java` | Master Theorem |
| 3 | `BTree.java` | B-Tree (Insertion, Search & Traversal) |
| 4 | `BPlusTree.java` | B+ Tree (Insertion, Search & Range Query) |
| 5 | `BinarySearch.java` | Binary Search |
| 6 | `MergeSort.java` | Merge Sort |
| 7 | `QuickSort.java` | Quick Sort |
| 8 | `FractionalKnapsack.java` | Fractional Knapsack (Greedy) |
| 9 | `JobSequencing.java` | Job Sequencing with Deadlines (Greedy) |
| 10 | `ZeroOneKnapsack.java` | 0/1 Knapsack (Dynamic Programming) |
| 11 | `LongestCommonSubsequence.java` | Longest Common Subsequence (Dynamic Programming) |

---

## Requirements

- **JDK 8** or later

---

## How to Compile

Open a terminal / command prompt in the project folder and run:

```bash
javac *.java
```

This compiles all 11 programs at once.

---

## How to Run Each Experiment (with Sample Input & Output)

Each program is interactive — it prompts you for input one value at a time. Below you will find the exact command to run, what inputs to type, and the expected output.

> **Note:** Execution times (`ns`) will vary on your machine. The values shown below are examples.

---

### Experiment 1 — Recursion Tree Method

```bash
java RecursionTreeMethod
```

**What it asks & what to type:**

| Prompt | Input to type |
|--------|---------------|
| `Enter a (number of subproblems):` | `2` |
| `Enter b (input-size division factor, > 1):` | `2` |
| `Enter c (coefficient of n^k):` | `1` |
| `Enter k (power in f(n) = c*n^k):` | `1` |
| `Enter n:` | `16` |

**Sample Output:**

```
Level-wise cost:
Level 0: 16.0000
Level 1: 16.0000
Level 2: 16.0000
Level 3: 16.0000
Level 4: 16.0000
Approximate number of leaves: 16.0000
Sum of internal-level costs: 80.0000
Compare k with log_b(a) = 1.0
Expected order: Theta(n^k log n)
Execution time: 69962900 ns
Time complexity of analysis program: O(log_b n)
```

**Explanation:** Analyses T(n) = 2T(n/2) + n by computing the cost at each recursion-tree level. Since k = log₂(2) = 1, it falls into the Θ(n log n) case.

---

### Experiment 2 — Master Theorem

```bash
java MasterMethod
```

**What it asks & what to type:**

| Prompt | Input to type |
|--------|---------------|
| `Enter a (number of subproblems):` | `2` |
| `Enter b (division factor, > 1):` | `2` |
| `Enter c (coefficient of n^k):` | `1` |
| `Enter k (power in f(n) = c*n^k):` | `1` |
| `Enter n for timing:` | `16` |

**Sample Output:**

```
Recurrence: T(n) = 2.0T(n/2.0) + 1.0n^1.0
log_b(a) = 1.0
Case 2: f(n) matches n^(log_b a).
Answer: Theta(n^(1.0) log n)
Sample sum used for timing: 136.0
Execution time: 15256200 ns
Time complexity of classification: O(1); sample sum: O(n)
```

**Explanation:** Classifies T(n) = 2T(n/2) + n using the Master Theorem. Since k = log_b(a) = 1, it's Case 2 → Θ(n log n).

---

### Experiment 3 — B-Tree

```bash
java BTree
```

**What it asks & what to type:**

| Prompt | Input to type |
|--------|---------------|
| `Enter minimum degree t (>= 2):` | `2` |
| `How many keys?` | `6` |
| `Key:` (1st) | `10` |
| `Key:` (2nd) | `20` |
| `Key:` (3rd) | `5` |
| `Key:` (4th) | `6` |
| `Key:` (5th) | `12` |
| `Key:` (6th) | `30` |
| `Search key:` | `6` |

**Sample Output:**

```
B-Tree traversal: 5 6 10 12 20 30
Execution time (insertion): 12700 ns
Insertion: O(log n) per key; all keys: O(n log n). Search: O(log n).
Search key: Key found
Search execution time: 3200 ns
```

**Explanation:** Builds a B-Tree of minimum degree 2, inserts 6 keys, prints the in-order traversal, then searches for key `6`.

---

### Experiment 4 — B+ Tree

```bash
java BPlusTree
```

**What it asks & what to type:**

| Prompt | Input to type |
|--------|---------------|
| `Enter order (maximum children, >= 3):` | `3` |
| `Number of keys:` | `6` |
| `Key:` (1st) | `10` |
| `Key:` (2nd) | `20` |
| `Key:` (3rd) | `5` |
| `Key:` (4th) | `6` |
| `Key:` (5th) | `12` |
| `Key:` (6th) | `30` |
| `Search key:` | `6` |
| `Range low and high:` | `1 25` |

**Sample Output:**

```
B+ Tree leaf sequence: [5, 6] [10, 12] [20, 30]
Insertion execution time: 87100 ns
Insertion: O(log n) per key; building n keys: O(n log n).
Key found
Search execution time: 14500 ns
Range low and high: 5 6 10 12 20
Range query execution time: 2291100 ns
Range search: O(log n + r), where r is the number of reported keys.
```

**Explanation:** Builds a B+ Tree of order 3, displays linked leaf nodes, searches for key `6`, then performs a range query for keys between 1 and 25.

---

### Experiment 5 — Binary Search

```bash
java BinarySearch
```

**What it asks & what to type:**

| Prompt | Input to type |
|--------|---------------|
| `Number of elements:` | `5` |
| `Element:` (1st) | `12` |
| `Element:` (2nd) | `25` |
| `Element:` (3rd) | `34` |
| `Element:` (4th) | `47` |
| `Element:` (5th) | `56` |
| `Enter key to search:` | `34` |

**Sample Output:**

```
Sorted array: [12, 25, 34, 47, 56]
Enter key to search: Found at sorted index 2
Execution time: 3200 ns
Time complexity: Best O(1), Average/Worst O(log n); Space: O(1).
```

**Explanation:** Sorts the array first, then searches for `34`. Found at index 2 (0-based) in the sorted array.

---

### Experiment 6 — Merge Sort

```bash
java MergeSort
```

**What it asks & what to type:**

| Prompt | Input to type |
|--------|---------------|
| `Number of elements:` | `6` |
| `Element:` (1st) | `38` |
| `Element:` (2nd) | `27` |
| `Element:` (3rd) | `43` |
| `Element:` (4th) | `3` |
| `Element:` (5th) | `9` |
| `Element:` (6th) | `82` |

**Sample Output:**

```
Sorted array: [3, 9, 27, 38, 43, 82]
Execution time: 10500 ns
Time complexity: Best/Average/Worst O(n log n); Space: O(n).
```

**Explanation:** Sorts the array `[38, 27, 43, 3, 9, 82]` using divide-and-conquer merge sort.

---

### Experiment 7 — Quick Sort

```bash
java QuickSort
```

**What it asks & what to type:**

| Prompt | Input to type |
|--------|---------------|
| `Number of elements:` | `6` |
| `Element:` (1st) | `38` |
| `Element:` (2nd) | `27` |
| `Element:` (3rd) | `43` |
| `Element:` (4th) | `3` |
| `Element:` (5th) | `9` |
| `Element:` (6th) | `82` |

**Sample Output:**

```
Sorted array: [3, 9, 27, 38, 43, 82]
Execution time: 10800 ns
Time complexity: Best/Average O(n log n), Worst O(n^2); Space: O(log n) average recursion.
```

**Explanation:** Sorts the same array using quick sort with the last element as pivot.

---

### Experiment 8 — Fractional Knapsack

```bash
java FractionalKnapsack
```

**What it asks & what to type:**

| Prompt | Input to type |
|--------|---------------|
| `Number of items:` | `3` |
| `Value and weight:` (Item 1) | `60 10` |
| `Value and weight:` (Item 2) | `100 20` |
| `Value and weight:` (Item 3) | `120 30` |
| `Knapsack capacity:` | `50` |

**Sample Output:**

```
Maximum value: 240.00
Execution time: 4391800 ns
Time complexity: O(n log n) due to sorting; Space: O(1) auxiliary (excluding sort).
```

**Explanation:** Three items with value/weight = `(60/10, 100/20, 120/30)`. With capacity 50, the greedy algorithm takes items by best value-to-weight ratio. All items fit (10+20+30 = 60 > 50), so it takes full items 1 and 2 (value = 160) and 2/3 of item 3 (value = 80), totalling 240.

---

### Experiment 9 — Job Sequencing with Deadlines

```bash
java JobSequencing
```

**What it asks & what to type:**

| Prompt | Input to type |
|--------|---------------|
| `Number of jobs:` | `4` |
| `Job ID, deadline, profit:` (Job 1) | `J1 2 100` |
| `Job ID, deadline, profit:` (Job 2) | `J2 1 50` |
| `Job ID, deadline, profit:` (Job 3) | `J3 2 10` |
| `Job ID, deadline, profit:` (Job 4) | `J4 1 20` |

**Sample Output:**

```
Scheduled jobs:
Slot 1: J2
Slot 2: J1
Maximum profit: 150
Execution time: 2628900 ns
Time complexity: O(n log n + nD), where D is maximum deadline.
```

**Explanation:** Jobs sorted by profit: J1(100) > J2(50) > J4(20) > J3(10). J1 (deadline 2) → slot 2. J2 (deadline 1) → slot 1. J3 and J4 cannot fit. Maximum profit = 100 + 50 = 150.

---

### Experiment 10 — 0/1 Knapsack

```bash
java ZeroOneKnapsack
```

**What it asks & what to type:**

| Prompt | Input to type |
|--------|---------------|
| `Number of items:` | `3` |
| `Weight and value:` (Item 1) | `2 3` |
| `Weight and value:` (Item 2) | `3 4` |
| `Weight and value:` (Item 3) | `4 5` |
| `Capacity:` | `5` |

**Sample Output:**

```
Maximum value: 7
Execution time: 52400 ns
Time complexity: O(n * capacity); Space: O(n * capacity).
```

**Explanation:** Three items with (weight, value) = (2,3), (3,4), (4,5). With capacity 5, the optimal selection is items 1 and 2 (weight 2+3 = 5, value 3+4 = 7).

---

### Experiment 11 — Longest Common Subsequence (LCS)

```bash
java LongestCommonSubsequence
```

**What it asks & what to type:**

| Prompt | Input to type |
|--------|---------------|
| `First string:` | `ABCBDAB` |
| `Second string:` | `BDCABA` |

**Sample Output:**

```
LCS: BCBA
LCS length: 4
Execution time: 137500 ns
Time complexity: O(m * n); Space: O(m * n).
```

**Explanation:** The longest common subsequence of `ABCBDAB` and `BDCABA` is `BCBA` with length 4.

---

## Algorithm Complexities Summary

| # | Algorithm | Best Case | Average Case | Worst Case | Space |
|---|-----------|-----------|--------------|------------|-------|
| 1 | Recursion Tree Method | O(log_b n) | O(log_b n) | O(log_b n) | O(1) |
| 2 | Master Theorem | O(1) | O(1) | O(1) | O(1) |
| 3 | B-Tree (per operation) | O(log n) | O(log n) | O(log n) | O(n) |
| 4 | B+ Tree (per operation) | O(log n) | O(log n) | O(log n) | O(n) |
| 5 | Binary Search | O(1) | O(log n) | O(log n) | O(1) |
| 6 | Merge Sort | O(n log n) | O(n log n) | O(n log n) | O(n) |
| 7 | Quick Sort | O(n log n) | O(n log n) | O(n²) | O(log n) |
| 8 | Fractional Knapsack | O(n log n) | O(n log n) | O(n log n) | O(1) |
| 9 | Job Sequencing | O(n log n) | O(n log n + nD) | O(n log n + nD) | O(D) |
| 10 | 0/1 Knapsack | O(nW) | O(nW) | O(nW) | O(nW) |
| 11 | LCS | O(mn) | O(mn) | O(mn) | O(mn) |

> Where: n = input size, W = knapsack capacity, D = max deadline, m & n = string lengths.

---

## Execution-Time Measurement

Every program measures the core algorithm's running time using Java's `System.nanoTime()`:

```java
long start = System.nanoTime();
// ... algorithm execution ...
long end = System.nanoTime();
System.out.println("Execution time: " + (end - start) + " ns");
```

`System.nanoTime()` returns a high-resolution timestamp in **nanoseconds**. The difference `end - start` gives the wall-clock time spent inside the measured block. Note that:

- Results are in **nanoseconds** (1 ms = 1,000,000 ns).
- Timings vary between machines, JVM warm-up states, and input sizes; they are illustrative, not formal benchmarks.
- For more reliable measurements, consider running each algorithm multiple times and averaging.

---

## Notes

- The B-Tree program includes insertion, splitting, traversal, and search.
- The B+ Tree program includes internal-node and leaf splitting, linked leaves, search, and range search.
- Recursion Tree and Master Method programs analyse recurrences of the form T(n) = aT(n/b) + c·n^k. For Master Method Case 3, the regularity condition is assumed.
