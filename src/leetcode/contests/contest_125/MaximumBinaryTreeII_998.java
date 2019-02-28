package leetcode.contests.contest_125;

import leetcode.TreeNode;

public class MaximumBinaryTreeII_998 {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        /**
         * Create a dummy node
         * */
        TreeNode dummy = new TreeNode(Integer.MAX_VALUE);
        /**
         * Set current node to its right node
         * */
        dummy.right = root;
        /**
         * Insert new node. We need access of the parent node
         * */
        ins(dummy, root, new TreeNode(val));
        /**
         * Return node without dummy
         * */
        return dummy.right;
    }

    /**
     * @param prev    Parent Node
     * @param curr    Root of the current node
     * @param newNode New Node to insert
     */
    private void ins(TreeNode prev, TreeNode curr, TreeNode newNode) {
        /**
         * If newnode value is greater than the current node
         * insert current node as left child of new node
         * newnode would be right child of the parent node
         * */
        if (newNode.val > curr.val) {
            newNode.left = curr;
            prev.right = newNode;
        } else {
            if (curr.right != null) {
                ins(curr, curr.right, newNode);
            } else {
                curr.right = newNode;
            }
        }
    }
}
