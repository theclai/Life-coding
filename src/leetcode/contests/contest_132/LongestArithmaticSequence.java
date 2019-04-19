package leetcode.contests.contest_132;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class LongestArithmaticSequence {
    LongestArithmaticSequence longestArithmaticSequence;

    @BeforeEach
    public void init() {
        longestArithmaticSequence = new LongestArithmaticSequence();
    }

  /*  @Test
    public void testExampleFirst() {
        int[] input = new int[]{3, 6, 9, 12};
        int res= longestArithmaticSequence.longestArithSeqLength( input);
        System.out.println(res);
    }*/

    @Test
    public void testExampleSecond() {
        int[] input = new int[]{9,4,7,2,10};
        int res= longestArithmaticSequence.longestArithSeqLength( input);
        System.out.println(res);
    }

    public int longestArithSeqLength(int[] A) {
        int max=0;
        int[] output=new int[A.length];
        Arrays.fill(output,1);
        for (int i = 1; i < A.length; i++) {
            int val=A[i];
            int it=i-1;
            while (it>=0){
                if(val>A[it]){
                    output[i]=Math.max(output[i],(1+output[it]));
                    max=Math.max(max,output[i]);
                    break;
                }

                it--;
            }

        }
        return max;

    }
}
