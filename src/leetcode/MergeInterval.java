package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MergeInterval {
    public static void main(String[] args) {
        List<Interval> list=new ArrayList<>();
        list.add(new Interval(1,3));
        list.add(new Interval(15,18));
        list.add(new Interval(8,10));
        list.add(new Interval(2,6));
        List<Interval> output=merge(list);
        output.forEach(interval -> System.out.println(interval.start+"->"+interval.end));
    }
    public static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public static List<Interval> merge(List<Interval> intervals) {
        intervals.sort(Comparator.comparingInt(i -> i.start));
        //intervals.forEach(interval -> System.out.println(interval.start));
        if(intervals==null) return null;
        if(intervals.size()==0) return intervals;
        if(intervals.size()==1) return intervals;

        List<Interval> res=new LinkedList<>();
        ((LinkedList<Interval>) res).addLast(intervals.get(0));
        for(int i=1;i<intervals.size();i++){
            Interval temp=((LinkedList<Interval>) res).removeLast();
            Interval data=intervals.get(i);
            if(data.start<=temp.end){
                Interval newInt=new Interval(Math.min(temp.start,data.start),
                        Math.max(temp.end,data.end));
                ((LinkedList<Interval>) res).addLast(newInt);
            }else {
                ((LinkedList<Interval>) res).addLast(temp);
                ((LinkedList<Interval>) res).addLast(data);
            }
        }

        return res;
    }
}
