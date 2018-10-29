package leetcode.contests;

public class BinarySubArraysWithSum {
    public static void main(String[] args) {
        //int[] A=new int[]{1,0,1,0,1};
        int[] A=new int[]{0,0,0,0,0};
        int S=0;
        BinarySubArraysWithSum bs=new BinarySubArraysWithSum();
        System.out.println(bs.numSubarraysWithSum(A,S));
    }

    public int numSubarraysWithSum(int[] A, int S) {
        if(A==null || A.length==0||S<0)
            return 0;
        int i=0;
        int j=0;
        int tSum=0;
        int counter=0;
        while(i<A.length && j<=A.length){
            tSum=tSum+A[j];
            if(tSum==S){
                counter++;
            }
            j++;
            if(j>=A.length || tSum>S ){
                tSum=0;
                i++;
                j=i;
            }

        }

        return counter;

    }
}
