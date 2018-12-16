package leetcode.binary_tree;

import leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaxWidthOfBT {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;

        // Initialize result
        int maxwidth = 0;

        // Do Level order traversal keeping
        // track of number of nodes at every level
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            // Get the size of queue when the level order
            // traversal for one level finishes
            int count = q.size();

            // Update the maximum node count value
            maxwidth = Math.max(maxwidth, count);

            // Iterate for all the nodes in
            // the queue currently
            while (count-- > 0) {
                // Dequeue an node from queue
                TreeNode temp = q.remove();

                // Enqueue left and right children
                // of dequeued node
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
        }
        return maxwidth;

    }
}
