package leetcode.contests.contest_129;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ThreePartEqualSum {
    ThreePartEqualSum threePartEqualSum;

    @BeforeEach
    public void init() {
        threePartEqualSum = new ThreePartEqualSum();
    }

    @Test
    public void canThreePartsEqualSumPositive() {
        boolean result = threePartEqualSum.canThreePartsEqualSum(new int[]{0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1});
        Assertions.assertEquals(true, result);
    }

    @Test
    public void canThreePartsEqualSumNegative() {
        boolean result = threePartEqualSum.canThreePartsEqualSum(new int[]{0, 2, 1, -6, 6, 7, 9, -1, 2, 0, 1});
        Assertions.assertEquals(false, result);
    }

    @Test
    public void canThreePartsEqualSumPositiveFirst() {
        boolean result = threePartEqualSum.canThreePartsEqualSum(new int[]{3, 3, 6, 5, -2, 2, 5, 1, -9, 4});
        Assertions.assertEquals(true, result);
    }

    @Test
    public void canThreePartsEqualSumPositiveSec() {
        boolean result = threePartEqualSum.canThreePartsEqualSum(new int[]{12,-4,16,-5,9,-3,3,8,0});
        Assertions.assertEquals(true, result);
    }

    public boolean canThreePartsEqualSum(int[] A) {
        int sum = Arrays.stream(A).sum();
        int target = sum / 3;
        int first = findPartition(0, A, target);
        //System.out.println("first position"+first);
        if (first == -1 || first == A.length) return false;
        int second = findPartition(first, A, target);
        //System.out.println("first position"+second);
        if (second == -1 || second == A.length) return false;
        int third = findPartition(second, A, target);
        if (third == -1) return false;
        return true;

    }

    private int findPartition(int i, int[] arr, int target) {
        int start = i;
        while (start < arr.length && target != 0) {
            target = target - arr[start];
            start++;
        }
        if (target != 0) return -1;
        return start;
    }

}
