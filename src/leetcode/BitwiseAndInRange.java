package leetcode;

public class BitwiseAndInRange {
    public static void main(String[] args){
        int low=5;
        int high=7;
        computeNaive(low,high);
        System.out.println(advanceCompute(low,high));
    }



    private static int advanceCompute(int low, int high) {
        int count=0;
        while(low!=high){
            low >>= 1;
            high >>= 1;
            count++;
        }
        System.out.println(low << count);
        return low<<count;


    }

    private static void computeNaive(int low, int high) {
        int temp=low;
        while(low<high){
            temp=temp & (low+1);
            low++;
        }
        System.out.println(temp);
    }
}
