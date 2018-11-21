package dailycodings;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Given an array of integers and a number k, where 1 <= k <= length of the array, compute the maximum values of each subarray of length k.
 * <p>
 * For example, given array = [10, 5, 2, 7, 8, 7] and k = 3, we should get: [10, 7, 8, 8], since:
 * <p>
 * 10 = max(10, 5, 2)
 * 7 = max(5, 2, 7)
 * 8 = max(2, 7, 8)
 * 8 = max(7, 8, 7)
 * Do this in O(n) time and O(k) space. You can modify the input array in-place and you do not need to store the results. You can simply print them out as you compute them.
 */
// Solution Explanation: https://www.youtube.com/watch?v=ShbRCjvB_yQ
public class SlidingWindow {
    public static void main(String[] args) {
        int[] input = new int[]{10, 5, 2, 7, 8, 7};
        int k = 3;
        findMaxOfSubArray(input, k, input.length);
    }

    private static void findMaxOfSubArray(int[] input, int k, int n) {
        int i;
        Deque<Integer> deque = new LinkedList<>();
        // For very element, the previous smaller elements are useless so
        // remove them from deque
        for (i = 0; i < k; i++) {
            while (!deque.isEmpty() && input[i] >= input[deque.peekLast()])
                deque.removeLast();
            deque.addLast(i);
        }
        System.out.println("Value of i: " + i);
        for (; i < n; i++) {
            // print the result from deque
            System.out.println(input[deque.peek()]);
            // keep removing the element it is not part of the current window
            while (!deque.isEmpty() && deque.peek() <= i - k) {
                deque.removeFirst();
            }
            // add the largest number like before
            while (!deque.isEmpty() && input[i] >= input[deque.peekLast()]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }
// Print the maximum element of last window
        System.out.print(input[deque.peek()]);

    }
}
