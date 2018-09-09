package leetcode;

import java.util.ArrayList;
//3,8,0,9,2,5
public class RLEIterator {
    private int[] seq;
    private int iteratorCounter;

    public RLEIterator(int[] A) {
        ArrayList<Integer> seqList = new ArrayList<>();
        int c=0;
        while(c<A.length){
            int counter= A[c];
            int target=A[c+1];

            for(int i=0;i<counter;i++){
                seqList.add(target);
            }
            c+=2;
        }
        iteratorCounter = 0;
        seq= new int[seqList.size()];
        for(int i=0;i<seqList.size();i++){
            seq[i]=seqList.get(i);
        }
        seqList.clear();
    }

    public int next(int n) {
        int prev = iteratorCounter;
        int f = iteratorCounter + n;
        iteratorCounter = iteratorCounter + n;
        if (iteratorCounter >= seq.length) {
            return -1;
        }
        return seq[f - 1];

    }
}
