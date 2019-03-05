package leetcode.contests.contest_126;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MaxConsecutiveOneIII {
    MaxConsecutiveOneIII maxConsecutiveOnes;

    @BeforeEach
    public void init() {
        maxConsecutiveOnes = new MaxConsecutiveOneIII();
    }

    @Test
    public void first_test_positive() {
        int res = maxConsecutiveOnes.longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2);
        Assertions.assertEquals(6, res);
    }

    @Test
    public void second_test_positive() {
        int res = maxConsecutiveOnes.longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 3);
        Assertions.assertEquals(10, res);
    }

    @Test
    public void third_test_positive() {
        int res = maxConsecutiveOnes.longestOnes(new int[]{0, 0, 1, 1, 1, 0, 0}, 0);
        Assertions.assertEquals(3, res);
    }

    @Test
    public void fourth_test_positive() {
        int res = maxConsecutiveOnes.longestOnes(new int[]{1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1,
                1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1, 1}, 8);
        Assertions.assertEquals(25, res);
    }

    public int longestOnes(int[] A, int K) {
        int max = 0;
        int zeroCount = 0; // zero count in current window
        int i = 0; // slow pointer

        for (int j = 0; j < A.length; ++j) {
            if (A[j] == 0) { // move forward j, if current is 0, increase the zeroCount
                zeroCount++;
            }

            // when current window has more than K, the window is not valid any more
            // we need to loop the slow pointer until the current window is valid
            while (zeroCount > K) {
                if (A[i] == 0) {
                    zeroCount--;
                }
                i++;
            }
            max = Math.max(max, j - i + 1); // everytime we get here, the current window is valid
        }
        return max;
    }
}
