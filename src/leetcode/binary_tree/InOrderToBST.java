package leetcode.binary_tree;

import leetcode.TreeNode;

public class InOrderToBST {
    public static void main(String[] args) {
        int[] inorder = new int[]{2, 4, 7, 8, 10};
        TreeNode root = buildBST(inorder, 0, inorder.length - 1);
        System.out.println(root.val);
    }

    private static TreeNode buildBST(int[] inorder, int start, int end) {
        int mid = (start + end) / 2;
        System.out.println("Mid: " + mid);
        if (start== end)
            return new TreeNode(inorder[start]);
        if(start>end)
            return null;
        TreeNode root = new TreeNode(inorder[mid]);

        root.left = buildBST(inorder, start, mid - 1);
        root.right = buildBST(inorder, mid + 1, end);


        return root;
    }
}
