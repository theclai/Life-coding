package pramp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TimePlanner {

    /**
     * is there chance that duration is smaller than dur
     * <p>
     * slotsA = [[10, 50], [60, 120], [140, 210]]
     * slotsB = [[0, 15], [60, 70]]
     * <p>
     * dur=8
     * <p>
     * O(A+B);
     * O(1): constant
     * <p>
     * Steps: iterate both array at the same time
     * <p>
     * conditions
     */
    static int[] meetingPlanner(int[][] slotsA, int[][] slotsB, int dur) {
        if (slotsA == null || slotsB == null || slotsA.length == 0 || slotsB.length == 0)
            return new int[]{};

        Set<Integer> hashSet=new HashSet<>();

        List<int[]> list=new ArrayList<>();

        list.add(new int[]{1,2});
        System.out.println(list.toArray());

        int i = 0;
        int j = 0;

        while (i < slotsA.length && j < slotsB.length) {
            int startA = slotsA[i][0];
            int endA = slotsA[i][1];

            int startB = slotsA[j][0];
            int endB = slotsA[j][1];

            if (startA < endB || startB < endA) {
                int diffCase1 = Math.abs(endB - startA);
                int diffCase2 = Math.abs(endA - startB);

                if (diffCase1 >= dur && diffCase2 >= dur) {
                    return new int[]{slotsA[i][0], slotsA[i][0] + dur};
                } else if (startA > endB) {
                    j++;

                } else if (startB > endA) {
                    i++;
                } else {
                    i++;
                    j++;
                }
            }

        }
        return new int[]{};
    }

    public static void main(String[] args) {

    }


}
