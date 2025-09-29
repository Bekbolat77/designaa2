package metrics;

public class PerformanceTracker {
    private long comparisons;
    private long swaps;
    private long accesses;
    private long allocationsBytes;
    private long startNs, endNs;

    public void start() { startNs = System.nanoTime(); }
    public void stop() { endNs = System.nanoTime(); }

    public void compare() { comparisons++; }
    public void swap() { swaps++; }
    public void access() { accesses++; }
    public void alloc(long bytes) { allocationsBytes += bytes; }

    public long getComparisons() { return comparisons; }
    public long getSwaps() { return swaps; }
    public long getAccesses() { return accesses; }
    public long getAllocationsBytes() { return allocationsBytes; }
    public long getElapsedNs() { return endNs - startNs; }

    @Override
    public String toString() {
        return "comparisons=" + comparisons +
                ", swaps=" + swaps +
                ", accesses=" + accesses +
                ", allocBytes=" + allocationsBytes +
                ", elapsedMs=" + (getElapsedNs() / 1_000_000.0);
    }
}
