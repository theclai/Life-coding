package cracking_coding_int;

import leetcode.TreeNode;

/***
 * Given a sorted array with unique integers elements, write algo to create a BST with minimal height.
 * */
public class MinimalTree {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        // To make minimal height, we have to add half element in the left subtree and right half on the right subtree
        TreeNode tree = createminimalTree(array);
        System.out.println(tree.val);
    }

    private static TreeNode createminimalTree(int[] array) {
        return helper(array, 0, array.length - 1);
    }

    private static TreeNode helper(int[] array, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(array[mid]);
        root.left = helper(array, start, mid - 1);
        root.right = helper(array, mid + 1, end);
        return root;
    }
}
