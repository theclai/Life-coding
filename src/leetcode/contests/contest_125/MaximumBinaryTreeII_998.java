package leetcode.contests.contest_125;

import leetcode.TreeNode;

public class MaximumBinaryTreeII_998 {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        TreeNode dummy = new TreeNode(Integer.MAX_VALUE);
        dummy.right = root;
        ins(dummy, root, new TreeNode(val));
        return dummy.right;
    }

    private void ins(TreeNode prev, TreeNode curr, TreeNode val) {
        if (val.val > curr.val) {
            val.left = curr;
            prev.right = val;
        } else {
            if (curr.right != null) {
                ins(curr, curr.right, val);
            } else {
                curr.right = val;
            }
        }
    }
}
