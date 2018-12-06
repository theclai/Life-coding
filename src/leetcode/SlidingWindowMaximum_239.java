package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class SlidingWindowMaximum_239 {
    public static void main(String[] args) {
        int[] input = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        SlidingWindowMaximum_239 swm = new SlidingWindowMaximum_239();
        System.out.println(swm.maxSlidingWindow(input, k));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (k > len)
            return new int[0];
        int[] res = new int[len-k+1];

        PriorityQueue<Integer> pq = new PriorityQueue<>(k, Collections.reverseOrder());

        for (int i = 0; i < k; i++)
            pq.add(nums[i]);

        int j;
        for (j = k; j < len; j++) {
            res[j - k] = pq.peek();
            pq.add(nums[j]);
        }
        res[j-k]=pq.peek();

        Arrays.stream(res).forEach(d -> System.out.println(d));
        return res;
    }
}
