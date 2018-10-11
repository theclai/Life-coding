package com.practice;

public class MaxSumSubArray {
    public static void main(String[] args) {
        int[] data = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(basicKadane(data));
    }

    private static int basicKadane(int[] data) {
        int maxSum = 0;
        int curMax=0;
        int posStart=0;
        int posEnd=0;
        for (int i = 0; i < data.length; i++) {
            curMax= curMax + data[i];

            if (curMax < 0) {
                curMax = 0
            }else if(curMax>maxSum)
                maxSum=curMax;

        }
        return maxSum;
    }
}
