package dailycodings;

import leetcode.TreeNode;

public class MaxPathSum {
    static class Res{
        int val;
    }
    static TreeNode root;
    public static void main(String args[]) {
        root = new TreeNode(10);
        root.left = new TreeNode(2);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(-25);
        root.right.right.left = new TreeNode(3);
        root.right.right.right = new TreeNode(4);
        System.out.println("maximum path sum is : " +
                findMaxSum());
    }

    private static int findMaxSum() {
        return maxSum(root);
    }

    private static int maxSum(TreeNode root) {
        Res res=new Res();
        res.val=Integer.MIN_VALUE;
         helper(root,res);
         return res.val;
    }

    private static int helper(TreeNode node, Res res) {
        if(node==null)
            return 0;
        int l=helper(node.left,res);
        int r=helper(node.right,res);
        int max_single = Math.max(Math.max(l, r) + node.data,
                node.data);


        // Max Top represents the sum when the Node under
        // consideration is the root of the maxsum path and no
        // ancestors of root are there in max sum path
        int max_top = Math.max(max_single, l + r + node.data);

        // Store the Maximum Result.
        res.val = Math.max(res.val, max_top);

        return max_single;
    }
}
