package algorithms;

import metrics.PerformanceTracker;

public class SelectionSort implements SortAlgorithm {

    @Override
    public void sort(int[] a, PerformanceTracker t) {
        if (a == null) throw new IllegalArgumentException("array is null");
        int n = a.length;
        t.alloc(0);

        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;

            for (int j = i + 1; j < n; j++) {
                t.access(); t.access(); t.compare();
                if (a[j] < a[minIdx]) {
                    minIdx = j;
                }
            }

            if (minIdx != i) {
                int tmp = a[i];
                a[i] = a[minIdx];
                a[minIdx] = tmp;
                t.swap(); t.access(); t.access();
            }
        }
    }

    @Override
    public String name() {
        return "SelectionSort(baseline)";
    }
}
