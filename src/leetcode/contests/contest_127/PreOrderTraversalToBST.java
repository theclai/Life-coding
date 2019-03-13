package leetcode.contests.contest_127;

import leetcode.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class PreOrderTraversalToBST {
    PreOrderTraversalToBST preOrderTraversalToBST;
    int p = 0;
    int[] arr;

    @BeforeEach
    public void init() {
        preOrderTraversalToBST = new PreOrderTraversalToBST();
    }

    @Test
    public void first_preordertraversaltobst() {
        preOrderTraversalToBST.bstFromPreorder(new int[]{8, 5, 1, 7, 10, 12});
        //need to add validation
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        this.arr = preorder;
        return helper(Integer.MAX_VALUE);

    }

    private TreeNode helper(int limit) {
        if (p >= arr.length || arr[p] > limit)
            return null;
        int val = arr[p++];
        TreeNode node = new TreeNode(val);
        node.left = helper(val);
        node.right = helper(limit);
        return node;
    }
}

