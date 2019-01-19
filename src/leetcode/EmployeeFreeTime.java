package leetcode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EmployeeFreeTime {
    private static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

    }

    private List<List<Interval>> input;

    @BeforeEach
    public void init() {
        input = buildInput();
    }
    @Test
    public void test(){
        Assertions.assertEquals(3,employeeFreeTime(input).get(0).start);
        Assertions.assertEquals(4,employeeFreeTime(input).get(0).end);
    }

    private List<List<Interval>> buildInput() {
        List<Interval> intervals1 = new ArrayList<>();
        intervals1.add(new Interval(1, 2));
        intervals1.add(new Interval(5, 6));

        List<Interval> intervals2 = new ArrayList<>();
        intervals2.add(new Interval(1, 3));

        List<Interval> intervals3 = new ArrayList<>();
        intervals3.add(new Interval(4, 10));
        intervals1.add(new Interval(5, 6));

        List<List<Interval>> lists = new ArrayList<>();
        lists.add(intervals1);
        lists.add(intervals2);
        lists.add(intervals3);
        return lists;
    }

    public static List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        if (schedule == null || schedule.size() == 0) return null;
        List<Interval> list = new ArrayList<>();
        for (List<Interval> l : schedule) {
            list.addAll(l);
        }
        List<Interval> merged = merge(list);
        if (merged.size() == 1) return null;
        List<Interval> result = new ArrayList<>();
        for (int i = 1; i < merged.size(); i++) {
            Interval prev = merged.get(i - 1);
            Interval cur = merged.get(i);

            if (prev.end < cur.start) {
                result.add(new Interval(prev.end, cur.start));
            }
        }
        return result;
    }

    private static List<Interval> merge(List<Interval> intervals) {
        intervals.sort(Comparator.comparingInt(i -> i.start));
        //intervals.forEach(interval -> System.out.println(interval.start));
        if (intervals == null) return null;
        if (intervals.size() == 0) return intervals;
        if (intervals.size() == 1) return intervals;
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
