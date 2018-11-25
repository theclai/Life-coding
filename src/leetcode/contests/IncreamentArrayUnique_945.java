package leetcode.contests;

import java.util.Arrays;

public class IncreamentArrayUnique_945 {
    public static void main(String[] args) {
        //int[] in=new int[]{3,2,1,2,1,7};
        int[] in=new int[]{1,2,2};
        System.out.println(minIncrementForUnique(in));

    }

    public static int minIncrementForUnique(int[] A) {
        int count=0;
        Arrays.sort(A);
        int start=0;
        int end=A.length-1;
        while (start<end){
            int temp=start;
            /*
            while (A[temp]>=A[temp+1]){
                A[temp+1]=A[start+1]+1;
                count++;
            }
            */
            if(A[temp]>=A[temp+1]){
                count=count+Math.abs(A[temp]-A[temp+1])+1;
                A[temp+1]=A[temp+1]+(A[temp]-A[temp+1])+1;

            }
            temp++;
            start=temp;

        }

        return count;

    }
}
