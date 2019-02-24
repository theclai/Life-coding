package leetcode.contests.contest_124;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ConsecutiveBitFlips_995 {
    ConsecutiveBitFlips_995 consecutiveBitFlips_995;

    @BeforeEach
    public void init() {
        consecutiveBitFlips_995 = new ConsecutiveBitFlips_995();
    }

    @Test
    public void minKbitFlip_TestFirst_Positive() {
        int result=minKBitFlips(new int[]{0,1,0},1);
        Assertions.assertEquals(2,result);
    }

    public int minKBitFlips(int[] A, int K) {
        int N = A.length;
        int[] hint = new int[N];
        int ans = 0, flip = 0;

        // When we flip a subarray like A[i], A[i+1], ..., A[i+K-1]
        // we can instead flip our current writing state, and put a hint at
        // position i+K to flip back our writing state.
        for (int i = 0; i < N; ++i) {
            flip ^= hint[i];
            if (A[i] == flip) {  // If we must flip the subarray starting here...
                ans++;  // We're flipping the subarray from A[i] to A[i+K-1]
                if (i + K > N) return -1;  //If we can't flip the entire subarray, its impossible
                flip ^= 1;
                if (i + K < N) hint[i + K] ^= 1;
            }
        }

        return ans;
    }
}
