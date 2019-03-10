package leetcode.contests.contest_127;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class LargestSumAfterKNegation {
    LargestSumAfterKNegation lsk;

    @BeforeEach
    public void init() {
        lsk = new LargestSumAfterKNegation();
    }

    @Test
    public void first_largestSumKNegation_positive() {
        int res = largestSumAfterKNegations(new int[]{3, -1, 0, 2}, 3);
        Assertions.assertEquals(res, 6);
    }
    @Test
    public void second_largestSumKNegation_positive() {
        int res = largestSumAfterKNegations(new int[]{4,2,3}, 1);
        Assertions.assertEquals(res, 5);
    }
    @Test
    public void third_largestSumKNegation_positive() {
        int res = largestSumAfterKNegations(new int[]{2,-3,-1,5,-4}, 2);
        Assertions.assertEquals(res, 13);
    }
    @Test
    public void fourth_largestSumKNegation_positive() {
        int res = largestSumAfterKNegations(new int[]{-2,9,9,8,4}, 5);
        Assertions.assertEquals(res, 32);
    }

    @Test
    public void fifth_largestSumKNegation_positive() {
        int res = largestSumAfterKNegations(new int[]{1,3,2,6,7,9},
        3);
        Assertions.assertEquals(res, 26);
    }

    @Test
    public void sixth_largestSumKNegation_positive() {
        int res = largestSumAfterKNegations(new int[]{-8,3,-5,-3,-5,-2},
                6);
        Assertions.assertEquals(22, res);
    }

    public int largestSumAfterKNegations(int[] A, int K) {
        Arrays.sort(A);
        int i = 0;
        int k = 0;

        while (k < K && i < A.length) {
            if (A[i] < 0) {
                A[i] = -1 * A[i];
                i++;
            } else if (A[i] == 0) {
                k++;
            } else {
                Arrays.sort(A);
                while (k<K){
                    A[0]=-1*A[0];
                    k++;
                }
            }
            k++;
        }

        Arrays.stream(A).forEach(val -> System.out.println(val));
        int total = 0;
        for (int element : A) {
            total += element;
        }
        return total;
    }
}
