package leetcode.contests.contest_129;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SmallestIntegerDivisibleByK {
    SmallestIntegerDivisibleByK smallestIntegerDivisibleByK;

    @BeforeEach
    public void init() {
        smallestIntegerDivisibleByK = new SmallestIntegerDivisibleByK();
    }

    @Test
    public void divisibleByKFirst() {
        Assertions.assertEquals(1, smallestIntegerDivisibleByK.smallestRepunitDivByK(1));
    }
    @Test
    public void divisibleByKSecond() {
        Assertions.assertEquals(-1, smallestIntegerDivisibleByK.smallestRepunitDivByK(2));
    }

    @Test
    public void divisibleByKThird() {
        Assertions.assertEquals(3, smallestIntegerDivisibleByK.smallestRepunitDivByK(3));
    }

    @Test
    public void divisibleByKFourth() {
        Assertions.assertEquals(3, smallestIntegerDivisibleByK.smallestRepunitDivByK(17));
    }

    public int smallestRepunitDivByK(int K) {
        int[] input = new int[]{
                1,
                11,
                111,
                1111,
                11111,
                111111,
                1111111,
                11111111,
                111111111,
                1111111111
        };
        int i=0;
        while (i<input.length){
            if(input[i]%K==0)return i+1;
            i++;
        }
        return -1;
    }
}
