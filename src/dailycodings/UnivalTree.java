package dailycodings;

import leetcode.TreeNode;

public class UnivalTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(0);

        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(0);

        root.right.left.left = new TreeNode(1);
        root.right.left.right = new TreeNode(1);

        System.out.println(numberOfUnival(root));
    }

    private static int numberOfUnival(TreeNode root) {
        if (root == null)
            return 0;
        return univalHelper(root, root.left, root.right, 0);

    }

    private static int univalHelper(TreeNode root,
                                    TreeNode left,
                                    TreeNode right,
                                    int numberOfUnival) {
        if (left == null && right == null)
            return numberOfUnival + 1;
        if (root.val == left.val && root.val == right.val)
            return univalHelper(left, left.left, left.right, numberOfUnival) +
                    univalHelper(right, right.left, right.right, numberOfUnival) +
                    1;
        else {
            return univalHelper(left, left.left, left.right, numberOfUnival) +
                    univalHelper(right, right.left, right.right, numberOfUnival);
        }
    }
}
