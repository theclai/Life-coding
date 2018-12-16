package leetcode.contests;

import leetcode.TreeNode;

public class CompleteNessOfBT_958 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);

        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);

        two.left = four;
        two.right = five;

        three.left = six;

        root.left = two;
        root.right = three;

        System.out.println(getHeight(root, 0) + 1);
        System.out.println(isCompleteTree(root));

    }

    public static boolean isCompleteTree(TreeNode root) {
        int h = getHeight(root, 0) + 1;
        return helper(root, h , 1);
    }

    private static boolean helper(TreeNode root, int height, int level) {
        if (root == null) {
            return false;

        }
        if (level < height) {
            if (root.left == null)
                return false;
            return (helper(root.left, height, level + 1)||helper(root.right, height, level + 1));
        }
        return true;
    }

    private static int getHeight(TreeNode root, int h) {
        if (root == null) return h;
        else {
            int lh = getHeight(root.right, h + 1);
            int rh = getHeight(root.right, h + 1);
            return Math.max(lh, rh);
        }

    }
}
