package data_structure.heap;

public class MinHeap {
    int[] data;
    public MinHeap(){
        data=new int[]{10,8,9,7,15,12,11};
    }
    public int getParent(int i){
        return data[i/2];
    }
}
