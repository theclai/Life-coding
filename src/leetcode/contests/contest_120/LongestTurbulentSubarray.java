package leetcode.contests.contest_120;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LongestTurbulentSubarray {
    LongestTurbulentSubarray lon;

    @BeforeEach
    public void init() {
        lon = new LongestTurbulentSubarray();
    }

    @Test
    public void testFirst() {
        int res = lon.maxTurbulenceSize(new int[]{9, 4, 2, 10, 7, 8, 8, 1, 9});
        Assertions.assertEquals(5, res);
    }

    @Test
    public void testSecond() {
        int res = lon.maxTurbulenceSize(new int[]{4, 8, 12, 16});
        Assertions.assertEquals(2, res);
    }

    @Test
    public void testThird() {
        int res = lon.maxTurbulenceSize(new int[]{100});
        Assertions.assertEquals(1, res);
    }

    @Test
    public void testFour() {
        int res = lon.maxTurbulenceSize(new int[]{0, 1, 1, 0, 1, 0, 1, 1, 0, 0});
        Assertions.assertEquals(5, res);
    }


    public int maxTurbulenceSize(int[] A) {
        if (A == null || A.length == 0) return 0;
        if (A.length == 1) return 1;
        int len = A.length;
        int[][] tr = new int[A.length][2];
        tr[len - 1] = new int[]{0, 0};
        int max = 0;

        for (int i = len - 2; i >= 0; i--) {
            int target = targetGreater(tr, i + 1);
            System.out.println(target);
            if (target == 3) {
                if (A[i] > A[i + 1]) {
                    tr[i] = new int[]{0, 2};
                } else if (A[i] < A[i + 1]) {
                    tr[i] = new int[]{2, 0};
                } else {
                    tr[i] = new int[]{0, 0};
                }
            } else if (target == 1) {
                if (A[i] > A[i + 1]) {
                    tr[i] = new int[]{0, tr[i + 1][0] + 1};
                } else if (A[i] < A[i + 1]) {
                    tr[i] = new int[]{2, 0};
                } else {
                    tr[i] = new int[]{0, 0};
                }
            } else if (target == 2) {
                if (A[i] > A[i + 1]) {
                    tr[i] = new int[]{0, 2};
                } else if (A[i] < A[i + 1]) {
                    tr[i] = new int[]{tr[i + 1][1] + 1, 0};
                } else {
                    tr[i] = new int[]{0, 0};
                }
            }
            max = Math.max(max, Math.max(tr[i][0], tr[i][1]));
        }
        return max;
    }

    public int targetGreater(int[][] tr, int pos) {
        //1 greater
        //2 smaller
        //3 any
        if (tr[pos][0] > tr[pos][1])
            return 1;
        else if (tr[pos][0] < tr[pos][1])
            return 2;
        else return 3;
    }
}
