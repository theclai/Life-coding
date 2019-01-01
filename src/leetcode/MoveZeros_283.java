package leetcode;

import java.util.Arrays;

public class MoveZeros_283 {
    public static void main(String[] args) {
        int[] in = new int[]{0, 1, 0, 3, 12};
        moveZeroes(in);

        Arrays.stream(in).forEach(value -> System.out.println(value));
    }

    public static void moveZeroes(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, count, i);
                count++;
            }
        }

        while (count < nums.length) {
            nums[count] = 0;
            count++;
        }

    }

    private static void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}
