package org.example;

import algorithms.InsertionSort;
import algorithms.SelectionSort;
import algorithms.SortAlgorithm;
import metrics.PerformanceTracker;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] data = {5, 2, 9, 1, 5, 6};

        SortAlgorithm algo = new InsertionSort(); 
        PerformanceTracker t = new PerformanceTracker();

        t.start();
        algo.sort(data, t);
        t.stop();

        System.out.println("Sorted: " + Arrays.toString(data));
        System.out.println("Stats: " + t);
    }
}
