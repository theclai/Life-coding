package leetcode;
/**
 * For example: [3,8,0,9,2,5] gets expanded and stored as 3 times 8, 0 times 9 and 2 times 5 i.e., [8,8,8,5,5]. When next() gets called with n = 2,
 * remove first 2 elements from the array from front and return the last element.
 * */
public class RLEIterator {
    private int[] seq;
    private int index=0;
    private int len;

    public RLEIterator(int[] A) {
        this.seq=A;
        this.len=A.length;
    }

    public int next(int n) {
        if(n>0){
            while(index<len){
                if(seq[index]==0){ // move to step forward if 0
                    index+=2;
                }else if(seq[index]<n){
                    n=n-seq[index];
                    index+=2;
                }else if(seq[index]>=n){ // if the number of times is bigger, update the value of that index
                    seq[index]=seq[index]-n;
                    return seq[index+1];
                }
            }
        }
        return -1;
    }
}
