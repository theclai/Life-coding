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

    public int longestOnes(int[] A, int K) {
        if(K>=A.length) return A.length;
        int left = 0;
        int right = 0;
        int total=0;
        while (left <= right && right < A.length) {
            if(A[right]==0 && K>0){
                K--;
                right++;
            }else if(A[right]==1){
                right++;
            }else{
                total=Math.max(total,(right-left));
                left++;
                if(A[left-1]==0)
                    K++;
            }

        }
        return total;
    }
}
