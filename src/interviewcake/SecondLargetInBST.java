package interviewcake;

import leetcode.TreeNode;

public class SecondLargetInBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(5);
        root.right = new TreeNode(30);
        root.right.right = new TreeNode(40);
        System.out.println(findSecondLarget(root).val);
    }

    private static TreeNode findSecondLarget(TreeNode root) {
        if (root == null)
            return null;
        if (root.right.right != null)
            return findSecondLarget(root.right);
        else
            return root;
    }
}
