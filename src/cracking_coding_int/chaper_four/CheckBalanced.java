package cracking_coding_int.chaper_four;

import tree.TreeNode;

public class CheckBalanced {
    boolean isBalanced(TreeNode root){
        return checkHeight(root)!=Integer.MIN_VALUE;
    }

    private int checkHeight(TreeNode root) {
        if(root==null) return -1;
        int left=checkHeight(root.left);
        if(left==Integer.MIN_VALUE) return Integer.MIN_VALUE;

        int right=checkHeight(root.right);
        if(right==Integer.MIN_VALUE) return Integer.MIN_VALUE;

        int diff=right-left;
        if(Math.abs(diff)>1) return Integer.MIN_VALUE;
        else return Math.max(left,right)+1;
    }
}
