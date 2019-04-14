package leetcode.contests.contest_132;

import leetcode.TreeNode;

public class MaxdifferenceNodeAndAncestor {
    static int maxVal;
    public static void main(String[] args) {
       /* TreeNode root=new TreeNode(8);
        root.left=new TreeNode(3);
        root.left.left=new TreeNode(1);
        root.left.right=new TreeNode(6);
        root.left.right.left=new TreeNode(4);
        root.left.right.right=new TreeNode(7);

        root.right=new TreeNode(10);
        root.right.right=new TreeNode(14);
        root.right.right.left=new TreeNode(13);*/

       TreeNode root=new TreeNode(2);
       root.right=new TreeNode(0);
       root.right.left=new TreeNode(1);
        maxAncestorDiff(root);
        System.out.println(maxVal);
    }

    public static int maxAncestorDiff(TreeNode root) {
       helper(root);
       return maxVal;
    }

    public static void helper(TreeNode root){
        if(root==null)return;
        int min= findMin(root,root.val);
        int max=findMax(root,root.val);
        maxVal= Math.max(maxVal,(Math.max(Math.abs(root.val-min),Math.abs(root.val-max))));

        maxAncestorDiff(root.left);
        maxAncestorDiff(root.right);
    }
    private static int findMin(TreeNode root,int min) {
        if(root.left==null)return root.val;
        return Math.min(min,findMin(root.left,min));
    }

    private static int findMax(TreeNode root,int max) {
        if(root.right==null)return root.val;
        return Math.max(max,findMin(root.right,max));
    }
}
