package leetcode.contests.contest_122;

import leetcode.TreeNode;

public class SmallestFromLeaf {
    static String ans = "~";

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);

        System.out.println(smallestFromLeaf(root));
    }

    public static String smallestFromLeaf(TreeNode root) {
        if (root == null) return "";
        helper(root, new StringBuilder());
        return ans;
    }

    public static void helper(TreeNode node, StringBuilder sb) {
        if (node == null) return;
        sb.append((char) ('a' + node.val));

        if (node.left == null && node.right == null) {
            sb.reverse();
            String S = sb.toString();
            sb.reverse();

            if (S.compareTo(ans) < 0)
                ans = S;
        }
        helper(node.left, sb);
        helper(node.right, sb);
        sb.deleteCharAt(sb.length() - 1);
    }
}
