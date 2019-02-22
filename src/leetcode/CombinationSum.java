package leetcode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        //2,3,6,7
        int[] arr = new int[]{2, 3, 6, 7};
        int target = 7;
        combinationSum(arr, target);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(candidates, 0, target, 0, temp, result);
        return result;
    }

    private static void helper(int[] candidates,
                               int start,
                               int target,
                               int sum,
                               List<Integer> temp,
                               List<List<Integer>> result) {
        if (sum > target) return;
        if (sum == target) result.add(new ArrayList<>(temp));

        for (int i = start; i < candidates.length; i++) {
            temp.add(candidates[i]);
            helper(candidates, i, target, sum + candidates[i], temp, result);
            temp.remove(temp.size() - 1);
        }
    }
}
