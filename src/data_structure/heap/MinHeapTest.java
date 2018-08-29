package data_structure.heap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MinHeapTest {
    MinHeap minHeap;
    @BeforeEach
    public void init(){
        minHeap=new MinHeap();

    }
    @Test
    public void getParentTest(){
        int parent = minHeap.getParent(3);
        Assertions.assertEquals(8,parent);

    }
}
