package leetcode;

public class BinaryTreePruning {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(0);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);
        BinaryTreePruning btp = new BinaryTreePruning();
        TreeNode r=btp.pruneTree(root);
        System.out.println(r.val);
    }

    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        } else if (root.val == 0 && root.left == null && root.right == null) {
            root = null;
        } else {
            root.left = pruneTree(root.left);
            root.right = pruneTree(root.right);
        }
        return root;
    }
}
