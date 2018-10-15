package data_structure.heap;

import java.util.Arrays;

public class MinHeap {
    int[] data;
    private int size = 0;
    private int capacity = 10;

    public MinHeap() {
        data = new int[capacity];
    }

    public void ensureExtraCapacity() {
        if (size == capacity) {
            data = Arrays.copyOf(data, capacity * 2);
            capacity *= 2;
        }
    }

    private int getParent(int index) {
        return data[getParentIndex(index)];
    }

    private int getLeft(int index) {
        return data[getLeftChildIndex(index)];
    }

    private int getRight(int index) {
        return data[getRightChildIndex(index)];
    }

    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    private int getLeftChildIndex(int parent) {
        return 2 * parent + 1;
    }

    private int getRightChildIndex(int parent) {
        return 2 * parent + 2;
    }

    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

    private boolean hasParent(int index) {
        return getParent(index) >= 0;
    }

    private void swap(int indexOne, int indexTwo) {
        int temp = data[indexOne];
        data[indexOne] = data[indexTwo];
        data[indexTwo] = temp;
    }


    // Peek the root element of the heap which is the min
    public int min() {
        if (size == 0) throw new IllegalArgumentException("There is no data in the array");
        return data[0];
    }


    /**
     * find the min element and remove from the data
     */
    public int minAndRemove() {
        if(size==0) throw new IllegalStateException();
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

    public void add(int item){
        ensureExtraCapacity();
        data[size]=item;
        size++;
        heapifyUp();
    }

    private void heapifyUp() {
        int index=size-1;
        // Keep going up as long as you have parents
        // and swap if the parent is bigger
        while(hasParent(index) && getParent(index)>data[index]){
            swap(getParentIndex(index),index);
            // After moving up change the pointer to it
            index=getParentIndex(index);
        }

    }


    /**
     * It heapify from top to bottom since violation happened on the top
     */
    private void heapifyDown() {
        int index =  0;
        //We need to check only left child because if there
        //is not left child, it wont have right child at all
        while(hasLeftChild(index)){
            // Get smaller child
            int smallerChildIndex = getLeftChildIndex(index);
            if(hasRightChild(index) && getRight(index)<getLeft(index)){
                smallerChildIndex= getRightChildIndex(index);
            }
            if(data[index]<data[smallerChildIndex]){
                break;
            }else{
                swap(index,smallerChildIndex);
            }
            index=smallerChildIndex;

        }


    }


}
