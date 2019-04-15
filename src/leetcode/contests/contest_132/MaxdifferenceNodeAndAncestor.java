package leetcode.contests.contest_132;

import leetcode.TreeNode;

public class MaxdifferenceNodeAndAncestor {
    static int maxdiff;

    public static void main(String[] args) {
       /* TreeNode root=new TreeNode(8);
        root.left=new TreeNode(3);
        root.left.left=new TreeNode(1);
        root.left.right=new TreeNode(6);
        root.left.right.left=new TreeNode(4);
        root.left.right.right=new TreeNode(7);

        root.right=new TreeNode(10);
        root.right.right=new TreeNode(14);
        root.right.right.left=new TreeNode(13);*/

        TreeNode root = new TreeNode(2);
        root.right = new TreeNode(0);
        root.right.left = new TreeNode(1);
        maxAncestorDiff(root);
        System.out.println(maxdiff);
    }

    public static int maxAncestorDiff(TreeNode root) {
        if (null == root) return 0;
        maxdiff = 0;
        dfs(root, root.val, root.val);
        return maxdiff;
    }

    public static void dfs(TreeNode root, int min, int max) {
        if (root == null) return;
        int diff1 = Math.abs(root.val - min);
        int diff2 = Math.abs(root.val - max);
        maxdiff = Math.max(maxdiff, diff1);
        maxdiff = Math.max(maxdiff, diff2);
        dfs(root.left, Math.min(min, root.val), Math.max(max, root.val));
        dfs(root.right, Math.min(min, root.val), Math.max(max, root.val));
    }
}
