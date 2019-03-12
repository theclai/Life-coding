package leetcode.contests.contest_127;

import leetcode.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PreOrderTraversalToBST {
    PreOrderTraversalToBST preOrderTraversalToBST;

    @BeforeEach
    public void init() {
        preOrderTraversalToBST = new PreOrderTraversalToBST();
    }

    @Test
    public void first_preordertraversaltobst() {
        preOrderTraversalToBST.bstFromPreorder(new int[]{8, 5, 1, 7, 10, 12});
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        buildTree(root, 1, preorder.length, preorder);
        return root;

    }

    private TreeNode buildTree(TreeNode root, int left, int right, int[] in) {


    }

    private int findRight(int val, int left, int[] in) {
        while (left + 1 < in.length) {
            if (in[left + 1] > val)
                return left;
            left++;
        }
        return -1;
    }
}

