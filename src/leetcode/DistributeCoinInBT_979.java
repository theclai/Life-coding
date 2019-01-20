package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DistributeCoinInBT_979 {
    DistributeCoinInBT_979 dc;
    TreeNode root;

    @BeforeEach
    public void init() {
        dc = new DistributeCoinInBT_979();
        root = new TreeNode(3);
        root.left = new TreeNode(0);
        root.right = new TreeNode(0);
    }

    @Test
    public void firstTest() {
        Assertions.assertEquals(2, dc.distributeCoins(root));
    }

    private int numSteps = 0;

    public int distributeCoins(TreeNode root) {
        dfs(root);
        return numSteps;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        numSteps = Math.abs(left) + Math.abs(right);
        return root.val - 1 + left + left;
    }
}
