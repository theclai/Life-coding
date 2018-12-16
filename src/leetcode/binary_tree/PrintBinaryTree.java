package leetcode.binary_tree;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintBinaryTree {
    public List<List<String>> printTree(TreeNode root) {
        int height = getHeight(root);
        String[][] res = new String[height][(1 << height) - 1];
        for (String[] arr : res)
            Arrays.fill(arr, "");
        List<List<String>> ans = new ArrayList<>();
        fill(res, root, 0, 0, res[0].length);
        for (String[] arr : res)
            ans.add(Arrays.asList(arr));
        return ans;
    }

    /**
     *
     */
    private void fill(String[][] res,
                      TreeNode root,
                      int row,
                      int left,
                      int right) {
        if (root == null) return;
        res[row][(left + right) / 2] = "" + root.val;
        fill(res, root.left, row + 1, left, (left + right) / 2);
        fill(res, root.right, row + 1, (left + right + 1) / 2, right);
    }

    public int getHeight(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
}
