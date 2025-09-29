package cli;

import algorithms.*;
import metrics.PerformanceTracker;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class BenchmarkRunner {
    public static void main(String[] args) {
        int[] sizes = {100, 1000, 10_000, 100_000};
        SortAlgorithm[] algorithms = {
                new InsertionSort(),
                new SelectionSort()
        };

        String csvFile = "benchmark_results.csv";

        try (FileWriter writer = new FileWriter(csvFile)) {
            // ✅ CSV Header
            writer.write("Algorithm,n,Time(ms),Comparisons,Swaps,Accesses\n");

            for (SortAlgorithm algo : algorithms) {
                System.out.println("\n=== " + algo.name() + " ===");
                for (int n : sizes) {
                    int[] data = new Random(42).ints(n, -1_000_000, 1_000_000).toArray();

                    int[] copy = Arrays.copyOf(data, data.length);
                    PerformanceTracker tracker = new PerformanceTracker();

                    long start = System.nanoTime();
                    algo.sort(copy, tracker);
                    long end = System.nanoTime();

                    double elapsedMs = (end - start) / 1_000_000.0;

                    // ✅ Консольге шығару
                    System.out.printf("n=%-7d  time=%.3f ms  compares=%d  swaps=%d  accesses=%d%n",
                            n, elapsedMs, tracker.getComparisons(), tracker.getSwaps(), tracker.getAccesses());

                    // ✅ CSV-ге жазу
                    writer.write(String.format("%s,%d,%.3f,%d,%d,%d\n",
                            algo.name(), n, elapsedMs, tracker.getComparisons(),
                            tracker.getSwaps(), tracker.getAccesses()));
                }
            }
            System.out.println("\n📑 Results saved to " + csvFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
