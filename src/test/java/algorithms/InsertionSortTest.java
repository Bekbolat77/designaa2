package algorithms;

import metrics.PerformanceTracker;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class InsertionSortTest {   

    private final SortAlgorithm algo = new InsertionSort();

    @Test
    void handlesEmpty() {
        int[] a = {};
        algo.sort(a, new PerformanceTracker());
        assertArrayEquals(new int[]{}, a);
    }

    @Test
    void handlesSingleElement() {
        int[] a = {42};
        algo.sort(a, new PerformanceTracker());
        assertArrayEquals(new int[]{42}, a);
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
        int[] a = {3, 1, 2, 2, 3, 1};
        int[] expected = a.clone();
        Arrays.sort(expected);
        algo.sort(a, new PerformanceTracker());
        assertArrayEquals(expected, a);
    }

    @Test
    void sortsRandomLargeArray() {
        int n = 500;
        int[] a = new Random(1).ints(n).toArray();
        int[] expected = a.clone();
        Arrays.sort(expected);
        algo.sort(a, new PerformanceTracker());
        assertArrayEquals(expected, a);
    }
}
