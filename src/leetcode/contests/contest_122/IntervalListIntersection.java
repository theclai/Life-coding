package leetcode.contests.contest_122;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersection {
    public static void main(String[] args) {
        System.out.println(intervalIntersection(new Interval[0],new Interval[0]));

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

    public static Interval[] intervalIntersection(Interval[] A, Interval[] B) { if (A == null || A.length == 0 || B == null || B.length == 0) return new Interval[0];
        List<Interval> result = new ArrayList<>();
        int i = 0;int j = 0;
        int lenA = A.length;
        int lenB = B.length;
        while (i < lenA && j < lenB) {
            Interval inA = A[i];
            Interval inB = B[j];

            int minA = inA.start;
            int maxA = inA.end;

            int minB = inB.start;
            int maxB = inB.end;

            if(maxA<minB)
                i++;
            else if(maxB<minA)
                j++;
            else{
                Interval temp = new Interval(Math.max(minA, minB), Math.min(maxA, maxB));
                result.add(temp);
                if (temp.end == maxA)
                    i++;
                else
                    j++;
            }

        }

        Interval[] output = new Interval[result.size()];
        for (int k = 0; k < result.size(); k++) {
            output[k] = result.get(k);
        }
        return output;
    }
}
