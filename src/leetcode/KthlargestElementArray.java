package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthlargestElementArray {
    public static void main(String[] args) {
        int[] in=new int[]{3,2,1,5,6,4};
        System.out.println(findKthLargest(in,2));
    }
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);

        Arrays.stream(nums).forEach(value -> {
            pq.add(value);
            if(pq.size()>k)
                pq.poll();
        });
        return pq.peek();
    }
}
