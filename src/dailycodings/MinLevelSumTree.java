package dailycodings;

import leetcode.TreeNode;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class MinLevelSumTree {
    static TreeNode root;

    public static void main(String[] args) {
        root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(-1);
        root.left.right = new TreeNode(3);

        root.right = new TreeNode(-5);
        root.right.left = new TreeNode(-2);
        root.right.right = new TreeNode(6);

        System.out.println(minSum(root));
    }

    private static int minSum(TreeNode root) {
        Map<Integer, Integer> map = new TreeMap<>();
        helper(root, 0, map);
        int min = Integer.MAX_VALUE;
        Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, Integer> e = it.next();
            if (e.getValue() < min) min = e.getValue();
        }
        return min;
    }

    private static void helper(TreeNode root, int level, Map<Integer, Integer> map) {
        if (root == null)
            return;
        map.putIfAbsent(level, 0);
        map.computeIfPresent(level, (k, v) -> v + root.val);
        helper(root.left, level + 1, map);
        helper(root.right, level + 1, map);
    }
}
