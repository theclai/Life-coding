package data_structure.heap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MaxHeapTest {
    MaxHeap maxHeap;

    @BeforeEach
    public void init(){
        maxHeap=new MaxHeap(10);
    }
    @Test
    public void insertTest(){
        maxHeap.insert(1);
        maxHeap.insert(2);
        maxHeap.insert(3);
        int max=maxHeap.getMax();
        System.out.println(max);

    }
}
