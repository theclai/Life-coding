package leetcode.contests.contest_132;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LongestSequence {
    LongestSequence longestSequence;

    @BeforeEach
    public void init() {
        longestSequence = new LongestSequence();
    }

    @Test
    public void testWhenInputHasUnorderElements() {
        int res = longestSequence.longestArithSeqLength(new int[]{9, 4, 7, 2, 10});
        Assertions.assertEquals(3,res);
    }

    public int longestArithSeqLength(int[] A) {
        int len = A.length;
        int max = 1;
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
            for (int j = i + 1; j < len; j++) {
                dp[i][j] = 2;
                int diff = A[j] - A[i];
                for (int k = i - 1; k >= 0; k--) {
                    if (A[i] - A[k] == diff) {
                        dp[i][j] = Math.max(dp[i][j], dp[k][i] + 1);
                        break;
                    }
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}
