package leetcode;

import java.util.*;

public class SlidingWindowMaximum_239 {
    public static void main(String[] args) {
        int[] input = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        //int[] input = new int[]{1,-1};
        int k = 3;
        SlidingWindowMaximum_239 swm = new SlidingWindowMaximum_239();
        swm.maxSlidingWindowAlt(input, k);
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (len == 0)
            return new int[0];
        if (k > len)
            return new int[0];
        int[] res = new int[len - k + 1];

        PriorityQueue<Integer> pq = new PriorityQueue<>(k, Collections.reverseOrder());

        for (int i = 0; i < k; i++)
            pq.add(nums[i]);

        int j;
        for (j = k; j < len; j++) {
            res[j - k] = pq.peek();
            pq.remove(pq.peek());
            pq.add(nums[j]);
        }

        res[j - k] = pq.peek();

        Arrays.stream(res).forEach(d -> System.out.println(d));
        return res;
    }

    public int[] maxSlidingWindowAlt(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return new int[0];

        int[] result = new int[nums.length - k + 1];

        LinkedList<Integer> deque = new LinkedList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (!deque.isEmpty() && deque.peekFirst() == i - k)
                deque.poll();

            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.removeLast();
            }

            deque.offer(i);

            if (i + 1 >= k)
                result[i + 1 - k] = nums[deque.peek()];
        }

        return result;
    }
}
