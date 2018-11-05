package leetcode;

public class BinaryTreePruning {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(0);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);
        BinaryTreePruning btp = new BinaryTreePruning();
        //TreeNode r=btp.pruneTree(root);
        //System.out.println(r.val);
        System.out.println(btp.pruneTreeEdge(root).val);

        System.out.println(8 == 5 || true || false);
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


    public TreeNode pruneTreeEdge(TreeNode root) {
        return containsOne(root) ? root : null;
    }

    private boolean containsOne(TreeNode root) {
        if (root == null) return false;
        boolean left = containsOne(root.left);
        boolean right = containsOne(root.right);
        if (!left) root.left = null;
        if (!right) root.right = null;
        return root.val == 1 || left || right;// any of the three statements is true will return true
    }
}
