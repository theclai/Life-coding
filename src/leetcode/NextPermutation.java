package leetcode;

public class NextPermutation {
    public static void main(String[] args) {

        //int[] in=new int[]{1,5,8,4,7,6,5,3,1};
        int[] in = new int[]{1, 2, 3};
        nextPermutation(in);
    }

    public static void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);

    }

    private static void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    public static void swap(int[] in, int start, int end) {
        int temp = in[end];
        in[end] = in[start];
        in[start] = temp;
    }
}
