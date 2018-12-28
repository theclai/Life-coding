package practice.elements_of_pro_interview_book;

import java.util.Arrays;

public class KthLargestElement {
    static int k = 3;

    public static void main(String[] args) {
        int[] in = new int[]{3, 1, -1, 2};
        System.out.println("result: " + findKthLargest(in,1));
    }

    public static int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) return Integer.MAX_VALUE;
        return findKthLargest(nums, 0, nums.length - 1, nums.length - k);
    }

    public static int findKthLargest(int[] nums, int start, int end, int k) {// quick select: kth smallest
        if (start > end) return Integer.MAX_VALUE;

        int pivot = nums[end];// Take A[end] as the pivot,
        int left = start;
        for (int i = start; i < end; i++) {
            if (nums[i] <= pivot) // Put numbers < pivot to pivot's left
                swap(nums, left++, i);
        }
        swap(nums, left, end);// Finally, swap A[end] with A[left]

        if (left == k)// Found kth smallest number
            return nums[left];
        else if (left < k)// Check right part
            return findKthLargest(nums, left + 1, end, k);
        else // Check left part
            return findKthLargest(nums, start, left - 1, k);
    }

    public static void swap(int[] in, int left, int right) {
        int temp = in[left];
        in[left] = in[right];
        in[right] = temp;
    }
}
