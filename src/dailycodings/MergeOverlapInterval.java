package dailycodings;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergeOverlapInterval {
    private static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

    }

    public static void main(String[] args) {
        ArrayList<Interval> list = new ArrayList<>();
        list.add(new Interval(1, 3));
        list.add(new Interval(5, 8));
        list.add(new Interval(4, 10));
        list.add(new Interval(20, 25));
        merge(list).stream().forEach(interval -> {
            System.out.println(interval.start + "->" + interval.end);
        });
    }

    private static List<Interval> merge(ArrayList<Interval> intervals) {
        intervals.sort(Comparator.comparingInt(i -> i.start));
        //intervals.forEach(interval -> System.out.println(interval.start));
        if(intervals==null) return null;
        if(intervals.size()==0) return intervals;
        if(intervals.size()==1) return intervals;
        List<Interval> result = new ArrayList<>();
        for (Interval itvl : intervals) {
            if (result.size() == 0)
                result.add(itvl);
            else {
                Interval it = result.get(result.size() - 1);
                if (it.end >= itvl.start) {
                    Interval interval = new Interval(Math.min(it.start, itvl.start),
                            Math.max(it.end, itvl.end));
                    result.add(interval);
                    result.remove(result.size() - 2);
                } else
                    result.add(itvl);
            }
        }
        return result;
    }
}
