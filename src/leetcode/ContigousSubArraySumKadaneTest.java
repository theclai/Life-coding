package leetcode;

import org.junit.jupiter.api.Test;

public class ContigousSubArraySumKadaneTest {
    private ContigousSubArraySumKadane algo;
    private int[] input= new int[]{-2,1,-3,4,-1,2,1,-5,4};
    @Test
    public void algoTest(){
        algo=new ContigousSubArraySumKadane();
        algo.subSum(input);
    }
}
