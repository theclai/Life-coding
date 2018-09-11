package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RLEIteratorTest {
    RLEIterator iterator;
    public RLEIteratorTest(){
        iterator=new RLEIterator(new int[]{3,8,0,9,2,5});
    }
    @Test
    public void firstTest(){
        int groundTruth= iterator.next(2);
        Assertions.assertEquals(8,groundTruth);

    }
}
