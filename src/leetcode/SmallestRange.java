package leetcode;

import java.util.Arrays;

public class SmallestRange {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] input=new int[] {0,10};
        int k=2;

        int res=smallest(input,k);
        System.out.println(res);

    }

    private static int smallest(int[] A, int k) {

        Arrays.sort(A);
        int max=A[0]+Math.abs(k);
        int maxDown=A[A.length-1]-k;

        return (maxDown-max)<0?0:(maxDown-max);

    }
}
