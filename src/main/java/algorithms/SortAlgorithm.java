package algorithms;

import metrics.PerformanceTracker;

public interface SortAlgorithm {
    void sort(int[] a, PerformanceTracker tracker);
    String name();
}
