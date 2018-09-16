package leetcode.binary_tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeTraversal {
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
        System.out.println("Inorder Traversal: ");
        inOrderTraversal(root);
        System.out.println();

        System.out.println("Pre-Order Traversal: ");
        preOrderTraversal(root);
        System.out.println();

        System.out.println("Post-Order Traversal: ");
        postOrderTraversal(root);
        System.out.println();

    }

    private static List<Integer> postOrderTraversal(TreeNode root) {
        if (root == null)
            return list;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        list.add(root.val);
        System.out.print(root.val + "->");
        return list;
    }

    public static List<Integer> inOrderTraversal(TreeNode root) {
        if (root == null)
            return list;
        inOrderTraversal(root.left);
        System.out.print(root.val + "->");
        list.add(root.val);
        inOrderTraversal(root.right);
        return list;
    }

    public static List<Integer> preOrderTraversal(TreeNode node) {
        if (node == null)
            return list;
        System.out.print(node.val + "->");
        list.add(node.val);
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
        return list;

    }
}
