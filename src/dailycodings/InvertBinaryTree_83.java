package dailycodings;

import leetcode.TreeNode;
/**
 *        1
 *       / \
 *      2   3
 *      /\
 *     5  7
 * */
public class InvertBinaryTree_83 {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);

        root.left.left=new TreeNode(5);
        root.left.right=new TreeNode(7);

        TreeNode result=invert(root);
        System.out.println(result.val);
    }

    private static TreeNode invert(TreeNode root) {
        TreeNode head=root;
        helper(root);
        return head;
    }

    private static void helper(TreeNode root) {
        if(root==null)
            return;
        TreeNode temp=null;
        if(root.right!=null)
            temp=root.right;

        root.right=root.left;
        root.left=temp;
        helper(root.left);
        helper(root.right);
    }
}
