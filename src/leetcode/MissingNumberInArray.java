package leetcode;

public class MissingNumberInArray {
    public static void main(String[] args){
        int[] in=new int[]{0,1,3};
        System.out.println(findMissing(in));
    }
    public static int findMissing(int[] nums){
        int len=nums.length;
        int sum=(len*(len+1))/2;
        System.out.println("Sum"+sum);

        int trueSum=0;
        for(int i=0;i<nums.length;i++){
            trueSum=trueSum+nums[i];
        }
        return sum-trueSum;
    }
}
