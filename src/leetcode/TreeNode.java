package leetcode;

public class TreeNode {
    int data,val;
    TreeNode left, right;
    TreeNode parent;

    TreeNode(int value) {
        data = value;
        this.val=value;
        left = right = null;
    }
}
