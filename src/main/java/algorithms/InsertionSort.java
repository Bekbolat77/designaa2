package algorithms;

import metrics.PerformanceTracker;

public class InsertionSort implements SortAlgorithm {

    @Override
    public void sort(int[] a, PerformanceTracker t) {
        if (a == null) throw new IllegalArgumentException("array is null");
        int n = a.length;
        t.alloc(0); 

        for (int i = 1; i < n; i++) {
            int key = a[i];
            t.access();
            int left = 0, right = i - 1;

            
            while (left <= right) {
                int mid = (left + right) >>> 1;
                t.access(); t.compare();
                if (a[mid] <= key) left = mid + 1;
                else right = mid - 1;
            }

            int j = i - 1;
            while (j >= left) {
                a[j + 1] = a[j];
                t.access(); t.swap();
                j--;
            }
            a[left] = key;
            t.access();
        }
    }

    @Override
    public String name() {
        return "InsertionSort(binary-insert)";
    }
}
