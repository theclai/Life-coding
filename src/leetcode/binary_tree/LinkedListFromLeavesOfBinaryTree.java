package leetcode.binary_tree;

import leetcode.TreeNode;

import java.util.LinkedList;

public class LinkedListFromLeavesOfBinaryTree {
    private static TreeNode root;

    public static void main(String[] args) {
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        LinkedList<TreeNode> leaves = new LinkedList<>();
        createLinkedList(root, leaves);
    }

    private static LinkedList<TreeNode> createLinkedList(TreeNode root, LinkedList<TreeNode> leaves) {
        if (root.left == null && root.right == null) {
            leaves.add(root);
        } else {
            createLinkedList(root.left, leaves);
            createLinkedList(root.right, leaves);
        }
        return leaves;
    }
}
