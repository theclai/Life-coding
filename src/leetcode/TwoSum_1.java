package leetcode;

import java.util.HashMap;

public class TwoSum_1 {
    public static void main(String[] args) {
        //int[] nums = new int[]{3,2,4};
        //int target = 6;

        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] result = findIndices(nums, target);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }

    private static int[] findIndices(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(nums[i]))
                return new int[]{map.get(nums[i]), i};
            else {
                map.put(diff, i);
            }
        }
        return new int[]{0, 0};
    }
}
