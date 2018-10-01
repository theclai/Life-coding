package cracking_coding_int;

import tree.TreeNode;

public class CheckBalance {
    private static TreeNode root;

    public static void main(String[] args) {
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        System.out.println(isBalance(root));
    }

    private static boolean isBalance(TreeNode root) {
        return checkBalance(root) != Integer.MIN_VALUE;
    }

    private static int checkBalance(TreeNode root) {
        if (root == null) return -1;
        int leftHts = checkBalance(root.left);
        System.out.println("Left Hts: " + leftHts);
        if (leftHts == Integer.MIN_VALUE) return Integer.MIN_VALUE;

        int rightHts = checkBalance(root.right);
        System.out.println("Right Hts: " + leftHts);
        if (rightHts == Integer.MIN_VALUE) return Integer.MIN_VALUE;

        int diff = Math.abs(leftHts - rightHts);
        if (diff > 1) {
            return Integer.MIN_VALUE;
        } else {
            return Math.max(leftHts, rightHts) + 1;
        }
    }
}
