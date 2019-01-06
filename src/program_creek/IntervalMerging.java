package program_creek;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class IntervalMerging {
    public static void main(String[] args) {
        Interval arr[] = new Interval[4];
        arr[0] = new Interval(6, 8);
        arr[1] = new Interval(1, 9);
        arr[2] = new Interval(2, 4);
        arr[3] = new Interval(4, 7);
        mergeIntervals(arr);
    }

    private static void mergeIntervals(Interval[] arr) {
        Arrays.sort(arr, Comparator.comparingInt(o -> o.start));
        Arrays.stream(arr).forEach(data -> System.out.println(data.start + "->" + data.end));

        int index=0;
        for (int i = 0; i <arr.length ; i++) {
            if(index!=0 && arr[index-1].start <= arr[i].end){
                while (index != 0 && arr[index-1].start <= arr[i].end)
                {
                    // Merge previous and current Intervals
                    arr[index-1].end = Math.max(arr[index-1].end, arr[i].end);
                    arr[index-1].start = Math.min(arr[index-1].start, arr[i].start);
                    index--;
                }
            }else{
                arr[index]=arr[i];
            }
            index++;
        }
    }

    static class Interval {
        public int start, end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
