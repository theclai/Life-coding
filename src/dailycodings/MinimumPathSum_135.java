package dailycodings;

import leetcode.TreeNode;

public class MinimumPathSum_135 {
    static TreeNode root;

    public static void main(String[] args) {
        root = new TreeNode(10);
        construct(root);
        int res = minPathSum(root);
        System.out.println(res);
    }

    private static void construct(TreeNode root) {
        root.left = new TreeNode(5);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(1);
        root.right.right.left = new TreeNode(-1);
    }

    public static int minPathSum(TreeNode root) {
        return helper(root);

    }

    private static int helper(TreeNode root) {
        if (root == null) return 0;
        int sum = root.val;
        int leftSum = Integer.MAX_VALUE;
        int rightSum = Integer.MAX_VALUE;
        if (root.right == null && root.left == null) {
            return sum;
        } else {

            if (root.left != null) {
                leftSum = minPathSum(root.left);
            }
            if (root.right != null) {
                rightSum = minPathSum(root.right);
            }
            sum += Math.min(leftSum, rightSum);
        }

        return sum;
    }
}
