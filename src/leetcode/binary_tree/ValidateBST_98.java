package leetcode.binary_tree;

public class ValidateBST_98 {
    /**
     * Left key has to be in range l,w
     * and right has to be in range of w,r
     * <p>
     * initial l=-INF and l=INF
     */
    public boolean isValidBST(TreeNode root) {
        return isKeysInRange(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isKeysInRange(TreeNode root, int minValue, int maxValue) {
        if (root == null) {
            return true;
        } else if ((Integer.compare(root.val, minValue) < 0) ||
                (Integer.compare(root.val, maxValue) > 0)) {
            return false;
        }
        return isKeysInRange(root.left, minValue, root.val) &&
                isKeysInRange(root.right, root.val, maxValue);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
