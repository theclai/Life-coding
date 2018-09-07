package leetcode;

public class BitwiseAndInRange {
    public static void main(String[] args){
        int low=5;
        int high=7;
        computeNaive(low,high);
        advanceCompute(low,high);
    }

    private static void advanceCompute(int low, int high) {
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
