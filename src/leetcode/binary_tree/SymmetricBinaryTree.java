package leetcode.binary_tree;


import leetcode.TreeNode;

public class SymmetricBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        isSymmetric(root);
    }

    private static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root.left, root.right);
    }

    private static boolean helper(TreeNode left, TreeNode right) {
        if(left==null && right==null){
            return true;
        }else if(left!=null && right!=null){
            return (left.val==right.val)&&
                    helper(left.left, right.right) &&
                    helper(left.right, right.left);
        }
        return false;
    }
}
