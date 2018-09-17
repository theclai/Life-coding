package leetcode.binary_tree;

public class ValidateBST_98 {
    public static void main(String[] args){
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        boolean valid=isValidBST(root);
        System.out.println(valid);
    }
    /**
     * Left key has to be in range l,w
     * and right has to be in range of w,r
     * <p>
     * initial l=-INF and l=INF
     */
    public static boolean isValidBST(TreeNode root) {
        return isKeysInRange(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean isKeysInRange(TreeNode root, long minValue, long maxValue) {
        if (root == null) {
            return true;
        } else if ((Long.compare(root.val, minValue) < 0) ||
                (Long.compare(root.val, maxValue) > 0)) {
            return false;
        }
        boolean left=isKeysInRange(root.left, minValue, root.val);
        boolean right=isKeysInRange(root.right, root.val, maxValue);
        return  left && right;

    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
