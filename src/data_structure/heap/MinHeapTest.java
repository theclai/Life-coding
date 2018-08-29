package data_structure.heap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MinHeapTest {
    MinHeap minHeap;

    @BeforeEach
    public void init() {
        minHeap = new MinHeap();
    }

    @Test
    public void getParentTest() {
        int parent = minHeap.getParent(3);
        Assertions.assertEquals(8, parent);
    }

    @Test
    public void getLeftTest() {
        int parent = minHeap.getLeft(2);
        Assertions.assertEquals(12, parent);
    }

    @Test
    public void getRightTest() {
        int parent = minHeap.getRight(0);
        Assertions.assertEquals(9, parent);
    }

    @Test
    public void swapTest(){
        minHeap.swap(1,6);
        Assertions.assertEquals(minHeap.data[1],11);
        Assertions.assertEquals(minHeap.data[6],8);
    }
}
