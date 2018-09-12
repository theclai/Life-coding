package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OverlapRectangleTest {
    OverlapRectangle rectangle;
    @Test
    public void overlapAreaTest(){
        rectangle=new OverlapRectangle();
        //rectangle.computeArea(-3,0,3,4,0,-1,9,2);
        int result=rectangle.computeArea(0,0,0,0,-1,-1,1,1);
        //int result= rectangle.computeArea(-2,-2,2,2,3,3,4,4);
        Assertions.assertEquals(4,result);


    }
}
