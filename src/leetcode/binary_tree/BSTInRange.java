package leetcode.binary_tree;

import leetcode.TreeNode;

/**
 * 10
 * /\
 * 5  50
 * /   /\
 * 1  40  100
 */
public class BSTInRange {
    static int ans=0;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(1);

        root.right = new TreeNode(50);
        root.right.left = new TreeNode(40);
        root.right.right = new TreeNode(100);

        int min = 5;
        int max = 45;
        bstInRangePrint(root, min, max);

        System.out.println(dfs(root,min,max));
    }

    private static void bstInRangePrint(TreeNode root, int min, int max) {
        if (root == null)
            return;

        if (root.val >= min && root.val <= max) {
            System.out.println(root.val);
            bstInRangePrint(root.left, min, max);
            bstInRangePrint(root.right, min, max);
        } else if (root.val < min) {
            bstInRangePrint(root.right, min, max);
        } else {
            bstInRangePrint(root.left, min, max);
        }
    }

    public static int dfs(TreeNode root,int min,int max){
        if (root == null)
            return ans;

        if (root.val >= min && root.val <= max) {
            ans=ans+root.val;
            dfs(root.left, min, max);
            dfs(root.right, min, max);
        } else if (root.val < min) {
            dfs(root.right, min, max);
        } else {
            dfs(root.left, min, max);
        }
        return ans;
    }
}
