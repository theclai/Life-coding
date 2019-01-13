package leetcode;

public class ValidBST {
    public boolean isBSTHelper(TreeNode node, Integer lower_limit, Integer upper_limit) {
        if ((lower_limit != null) && (node.val <= lower_limit))
            return false;
        if ((upper_limit != null) && (upper_limit <= node.val))
            return false;

        boolean left = node.left != null ? isBSTHelper(node.left, lower_limit, node.val) : true;
        if (left) {
            boolean right = node.right != null ? isBSTHelper(node.right, node.val, upper_limit) : true;
            return right;
        } else
            return false;
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;

        return isBSTHelper(root, null, null);
    }
}
