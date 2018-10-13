package practice;

public class MaxSumSubArray {
    public static void main(String[] args) {
        int[] data = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(basicKadane(data));
        basicKadaneWithPosition(data);
    }

    private static int basicKadane(int[] data) {
        int maxSum = 0;
        int curMax=0;
        for (int i = 0; i < data.length; i++) {
            curMax= curMax + data[i];
            if (curMax < 0) {
                curMax = 0;
            }else if(curMax>maxSum)
                maxSum=curMax;

        }
        return maxSum;
    }


    private static int basicKadaneWithPosition(int[] data) {
        int maxSum = 0;
        int curMax=0;
        int end=0;
        int start=0;
        for (int i = 0; i < data.length; i++) {
            curMax= curMax + data[i];
            if (curMax < 0) {
                curMax = 0;
                start=i+1;
            }else if(curMax>maxSum){
                maxSum=curMax;
                end=i;
            }
        }
        System.out.println(end+""+data[end]);
        System.out.println(start+"->"+data[start]);
        return maxSum;
    }
}
