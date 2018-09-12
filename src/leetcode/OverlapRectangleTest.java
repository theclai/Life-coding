package leetcode;

import org.junit.jupiter.api.Test;

public class OverlapRectangleTest {
    OverlapRectangle rectangle;
    @Test
    public void overlapAreaTest(){
        rectangle=new OverlapRectangle();
        rectangle.computeArea(-3,0,3,4,0,-1,9,2);
        //rectangle.computeArea(0,0,0,0,-1,-1,1,1);


    }
}
