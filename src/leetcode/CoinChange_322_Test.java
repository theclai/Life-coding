package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CoinChange_322_Test {
    CoinChange_322 coinChange;
    int[] coins,coins1;
    int amt,amt1;
    int groundTruth,groundTruth1;
    @BeforeEach
    public void init(){
        coinChange=new CoinChange_322();
        coins=new int[]{1,2,5};
        amt=11;
        groundTruth=3;

        coins1=new int[]{2};
        amt1=3;
        groundTruth1=-1;
    }

    @Test
    public void countTest(){
        int expected=coinChange.coinChange(coins,amt);
        Assertions.assertEquals(expected,groundTruth);
    }


}
