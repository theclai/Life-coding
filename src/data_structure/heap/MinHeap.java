package data_structure.heap;

public class MinHeap {
    int[] data;

    public MinHeap() {
        data = new int[]{10, 8, 9, 7, 15, 12, 11};
    }

    public int getParent(int i) {
        return data[i / 2];
    }

    public int getLeft(int i) {
        return data[2 * i + 1];
    }

    public int getRight(int i) {
        return data[2 * i + 2];
    }
    public void swap(int i,int j){
        int temp=data[i];
        data[i]=data[j];
        data[j]=temp;
    }

    /**
     * Build mean heap time complexity is n
     * since it needs to traverse all the elements
     */
    public void buildMeanHeap(int[] A, int s) {



    }


}
