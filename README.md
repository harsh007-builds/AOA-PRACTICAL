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

## Algorithm Descriptions & Complexities

### 1. Recursion Tree Method (`RecursionTreeMethod.java`)
Analyses a recurrence of the form **T(n) = aT(n/b) + c·n^k** by computing the cost at each level of the recursion tree and summing them up. Compares k with log_b(a) to determine the asymptotic order.

| Case | Time |
|------|------|
| Analysis program | **O(log_b n)** |
| **Space** | **O(1)** |

### 2. Master Theorem (`MasterMethod.java`)
Classifies a recurrence **T(n) = aT(n/b) + c·n^k** into one of three Master Theorem cases and outputs the asymptotic solution. Also computes a sample sum for meaningful timing.

| Case | Time |
|------|------|
| Classification | **O(1)** |
| Sample sum (for timing) | **O(n)** |
| **Space** | **O(1)** |

### 3. B-Tree (`BTree.java`)
Implements a B-Tree of minimum degree **t**. Supports insertion (with node splitting), in-order traversal, and key search.

| Operation | Time |
|-----------|------|
| Search / Insert (per key) | **O(log n)** |
| Build (n keys) | **O(n log n)** |
| **Space** | **O(n)** |

### 4. B+ Tree (`BPlusTree.java`)
Implements a B+ Tree with linked leaf nodes. Supports insertion (leaf and internal splitting), point search, range search, and leaf-level traversal.

| Operation | Time |
|-----------|------|
| Search / Insert (per key) | **O(log n)** |
| Build (n keys) | **O(n log n)** |
| Range query | **O(log n + r)** where r = reported keys |
| **Space** | **O(n)** |

### 5. Binary Search (`BinarySearch.java`)
Sorts the input array and performs iterative binary search for a user-specified key.

| Case | Time |
|------|------|
| Best | **O(1)** |
| Average / Worst | **O(log n)** |
| **Space** | **O(1)** (search itself) |

### 6. Merge Sort (`MergeSort.java`)
Recursive divide-and-conquer sorting algorithm that splits the array in half, sorts each half, and merges them back together.

| Case | Time |
|------|------|
| Best / Average / Worst | **O(n log n)** |
| **Space** | **O(n)** (temporary merge array) |

### 7. Quick Sort (`QuickSort.java`)
Recursive divide-and-conquer sort that partitions the array around a pivot element (last element) and sorts the partitions.

| Case | Time |
|------|------|
| Best / Average | **O(n log n)** |
| Worst (sorted input, bad pivot) | **O(n²)** |
| **Space** | **O(log n)** average recursion depth |

### 8. Fractional Knapsack (`FractionalKnapsack.java`)
Greedy algorithm that sorts items by value-to-weight ratio in descending order and fills the knapsack, taking fractions of items when needed.

| Case | Time |
|------|------|
| All cases (dominated by sort) | **O(n log n)** |
| **Space** | **O(1)** auxiliary (excluding sort) |

### 9. Job Sequencing with Deadlines (`JobSequencing.java`)
Greedy approach that sorts jobs by profit in descending order and assigns each job to the latest available time slot before its deadline.

| Case | Time |
|------|------|
| All cases | **O(n log n + nD)** where D = max deadline |
| **Space** | **O(D)** for slot array |

### 10. 0/1 Knapsack (`ZeroOneKnapsack.java`)
Dynamic programming solution that builds a 2-D table `dp[i][w]` to find the maximum value achievable within a given capacity, where each item is either taken entirely or not.

| Case | Time |
|------|------|
| All cases | **O(n × W)** where W = capacity |
| **Space** | **O(n × W)** |

### 11. Longest Common Subsequence (`LongestCommonSubsequence.java`)
Dynamic programming algorithm that fills a 2-D table to find the length and actual characters of the longest subsequence common to two strings, then backtracks to reconstruct it.

| Case | Time |
|------|------|
| All cases | **O(m × n)** where m, n = string lengths |
| **Space** | **O(m × n)** |

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

## How to Run

Execute any experiment by its class name:

```bash
java RecursionTreeMethod
java MasterMethod
java BTree
java BPlusTree
java BinarySearch
java MergeSort
java QuickSort
java FractionalKnapsack
java JobSequencing
java ZeroOneKnapsack
java LongestCommonSubsequence
```

Each program prompts for input interactively.

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
