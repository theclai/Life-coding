package dailycodings;

import java.util.*;

public class HitCounter_132 {
    static class Counter {
        long total;

        public Counter(long total) {
            this.total = total;
        }

        public long getTotal() {
            return total;
        }

        public void setTotal(long total) {
            this.total = total;
        }
    }

    static SortedMap<Long, Counter> counters;
    static long total = 0;

    public static void main(String[] args) {
        counters = getCounterMap();
        record(1);
        record(1);
        record(2);
        record(3);
        record(3);
        System.out.println(total);
        System.out.println(range(2,3));

    }

    private static SortedMap<Long, Counter> getCounterMap() {
        return Collections.synchronizedSortedMap(new TreeMap<>());
    }

    public static void record(long timestamp) {
        total+=1;
        counters.computeIfAbsent(timestamp, obj -> new Counter(total));
        counters.get(timestamp).setTotal(total);
    }

    public static long total() {
        return total;
    }

    public static long range(long low, long high) {
        return counters.get(high).getTotal() - counters.get(low-1).getTotal();
    }
}
