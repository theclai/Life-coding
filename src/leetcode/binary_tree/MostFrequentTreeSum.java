package leetcode.binary_tree;

import leetcode.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MostFrequentTreeSum {
    int max = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) return new int[0];
        Map<Integer, Integer> map = new HashMap<>();
        helper(root, map);
        List<Integer> res = new LinkedList<>();
        for (Map.Entry<Integer, Integer> me : map.entrySet()) {
            if (me.getValue() == max) res.add(me.getKey());
        }
        return res.stream().mapToInt(i -> i).toArray();
    }

    private int helper(TreeNode n, Map<Integer, Integer> map) {
        int left = (n.left == null) ? 0 : helper(n.left, map);
        int right = (n.right == null) ? 0 : helper(n.right, map);
        int sum = left + right + n.val;
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        max = Math.max(max, map.get(sum));
        return sum;
    }
}
