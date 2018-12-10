package leetcode;

public class FindPeakElement_162 {
    public static void main(String[] args) {
       // int[] input=new int[]{1,2,1,3,5,6,4};

        int[] input=new int[]{1,2};
        FindPeakElement_162 fp=new FindPeakElement_162();
        System.out.println(fp.findPeakElement(input));

    }

    public int findPeakElement(int[] nums) {

        if(nums.length==1)
            return 0;
        if (nums[0] > nums[nums.length - 1] && nums[0] > nums[1])
            return 0;

        if (nums[nums.length - 1] > nums[nums.length - 2] )
            return nums.length-1;

        for (int i = 1; i < nums.length - 1; i++)
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1])
                return i;
        return 0;
    }
}
