package leetcode.contests.contest_122;

import leetcode.TreeNode;

public class SmallestFromLeaf {
    public static void main(String[] args) {
        TreeNode root = new TreeNode('a');
        root.left = new TreeNode('b');
        root.right = new TreeNode('c');
        root.left.left = new TreeNode('d');
        root.left.right = new TreeNode('e');
        root.right.left = new TreeNode('d');
        root.right.right = new TreeNode('e');

        System.out.println(smallestFromLeaf(root));
    }

    public static String smallestFromLeaf(TreeNode root) {
        if(root==null)return "";
        return helper("", root);
    }

    public static String helper(String in, TreeNode node) {
        if (node.left == null && node.right == null)
            return node.c+in;
        String lStr=helper(node.c+in,node.left);
        String rStr=helper(node.c+in,node.left);
        if(lStr.compareTo(rStr)==0)return lStr;
        else if(lStr.compareTo(rStr)>0) return rStr;
        else return lStr;
    }
}
