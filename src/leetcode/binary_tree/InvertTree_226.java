package leetcode.binary_tree;

import java.util.ArrayList;
import java.util.List;

public class InvertTree_226 {
    static List<Integer> list = new ArrayList<>();

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        invertTree(root);

    }

    private static TreeNode invertTree(TreeNode root) {
        if(root==null)
            return root;
        TreeNode mainRoot=root;
        TreeNode tempRight=root.right;
        root.right=root.left;
        root.left=tempRight;


        invertTree(root.left);
        invertTree(root.right);
        return mainRoot;
    }

}
