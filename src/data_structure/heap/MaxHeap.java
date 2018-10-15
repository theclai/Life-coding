package data_structure.heap;

//
public class MaxHeap {
    private int[] data;
    private int currentPosition = 0;

    public MaxHeap(int size) {
        data = new int[10];// Need to resize if you want to add more data.
    }

    public int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    public int getParentData(int childIndex) {
        return data[childIndex - 1 / 2];
    }

    public int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    public int getLeftChild(int parentIndex) {
        return data[2 * parentIndex + 1];
    }

    public int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    public int getRightChild(int parentIndex) {
        return data[2 * parentIndex + 2];
    }

    public void insert(int val) {
        // insert data to the last
        data[currentPosition] = val;
        // propagate to up, maxHeapifyUp
        maxHeapifyUp(currentPosition);
        // increase the position
        currentPosition++;

    }

    public int getMax(){
        return data[0];
    }
    private void maxHeapifyUp(int currentPosition) {
        int parentIndex;
        if (currentPosition == 0) {
            return;
        } else {
            parentIndex = getParentIndex(currentPosition);
        }
        if (data[currentPosition] > data[parentIndex]) {
            swap(data, currentPosition, parentIndex);
            maxHeapifyUp(parentIndex);
        }
    }

    private void swap(int[] data, int currentPosition, int parentIndex) {
        int temp = data[parentIndex];
        data[parentIndex] = data[currentPosition];
        data[currentPosition] = temp;
    }

}
