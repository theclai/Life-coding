package leetcode;

public class TreeNode {
    public int data,val;
    public TreeNode left, right;
    public TreeNode parent;

    public TreeNode(int value) {
        data = value;
        this.val=value;
        left = right = null;
    }
}
