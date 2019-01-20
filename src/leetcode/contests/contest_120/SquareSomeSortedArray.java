package leetcode.contests.contest_120;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class SquareSomeSortedArray {
    SquareSomeSortedArray ssa;

    @BeforeEach
    public void init() {
        ssa = new SquareSomeSortedArray();

    }

    @Test
    public void testFirst() {
        int[] res= ssa.sortedSquares(new int[]{-4,-1,0,3,10});
        Assertions.assertEquals(0,res[0]);
        Assertions.assertEquals(100,res[4]);

    }

    @Test
    public void testSecond() {
        int[] res= ssa.sortedSquares(new int[]{-7,-3,2,3,11});
        Assertions.assertEquals(4,res[0]);
        Assertions.assertEquals(121,res[4]);

    }

    public int[] sortedSquares(int[] A) {
        if(A==null||A.length==0)return new int[]{};
        for (int i = 0; i < A.length; i++) {
            A[i] = A[i] * A[i];
        }
        Arrays.sort(A);
        return A;
    }
}
