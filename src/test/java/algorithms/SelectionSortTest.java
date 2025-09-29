package algorithms;

import metrics.PerformanceTracker;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class SelectionSortTest {

    private final SortAlgorithm algo = new SelectionSort();

    @Test
    void handlesEmpty() {
        int[] a = {};
        algo.sort(a, new PerformanceTracker());
        assertArrayEquals(new int[]{}, a);
    }

    @Test
    void handlesSingleElement() {
        int[] a = {7};
        algo.sort(a, new PerformanceTracker());
        assertArrayEquals(new int[]{7}, a);
    }

    @Test
    void sortsSmallArray() {
        int[] a = {5, 2, 9, 1, 5, 6};
        int[] expected = a.clone();
        Arrays.sort(expected);
        algo.sort(a, new PerformanceTracker());
        assertArrayEquals(expected, a);
    }

    @Test
    void sortsWithDuplicates() {
        int[] a = {2, 2, 1, 1, 3, 3};
        int[] expected = a.clone();
        Arrays.sort(expected);
        algo.sort(a, new PerformanceTracker());
        assertArrayEquals(expected, a);
    }

    @Test
    void sortsRandomLargeArray() {
        int n = 500;
        int[] a = new Random(2).ints(n).toArray();
        int[] expected = a.clone();
        Arrays.sort(expected);
        algo.sort(a, new PerformanceTracker());
        assertArrayEquals(expected, a);
    }
}
