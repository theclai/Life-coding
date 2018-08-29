package data_structure.heap;

import java.util.Arrays;

public class MinHeap {
    int[] data;
    int size = 0;
    int capacity = 10;

    public MinHeap() {
        data = new int[capacity];
    }

    public void ensureExtraCapacity() {
        if (size == capacity) {
            data = Arrays.copyOf(data, capacity * 2);
            capacity *= 2;
        }
    }

    public int getParent(int index) {
        return data[getParentIndex(index)];
    }

    public int getLeft(int index) {
        return data[getLeftChildIndex(index)];
    }

    public int getRight(int index) {
        return data[getRightChildIndex(index)];
    }

    public int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    public int getLeftChildIndex(int parent) {
        return 2 * parent + 1;
    }

    public int getRightChildIndex(int parent) {
        return 2 * parent + 2;
    }

    public boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    public boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

    public boolean hasParent(int index) {
        return getParent(index) >= 0;
    }

    public void swap(int indexOne, int indexTwo) {
        int temp = data[indexOne];
        data[indexOne] = data[indexTwo];
        data[indexTwo] = temp;
    }


    public int min() {
        if (size == 0) throw new IllegalArgumentException("There is no data in the array");
        return data[0];
    }

    /**
     * find the min element and remove from the data
     */
    public int minAndRemove() {
        // find the min
        int min = min();

        // get the last element
        int last = data[size - 1];
        // move it to the first positon
        data[0] = last;
        // shrink the array since one item has been removed
        size--;
        heapifyDown();
        return min;

    }

    /**
     * It heapify from top to bottom since violation happened on the top
     */
    private void heapifyDown() {
    }

    /**
     * Build mean heap time complexity is n
     * since it needs to traverse all the elements
     */
    public void buildMeanHeap(int[] A, int s) {
        int smallestPosition = s;
        int left = 2 * s + 1;
        int right = 2 * s + 2;
        if (left < A.length & A[s] > getLeft(s)) {
            smallestPosition = left;
        } else if (right < A.length & A[s] > getRight(s)) {
            smallestPosition = right;
        }
        if (smallestPosition != s) {
            swap(s, smallestPosition);
            buildMeanHeap(A, smallestPosition);
        }
    }


}
