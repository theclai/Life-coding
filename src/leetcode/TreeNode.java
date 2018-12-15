package leetcode;

public class TreeNode {
    public int data,val;
    public char c;
    public TreeNode left, right;
    public TreeNode parent;

    public TreeNode() {
    }

    public TreeNode(int value) {
        data = value;
        this.val=value;
        left = right = null;
    }

    public TreeNode(char value) {
        this.c = value;
        this.val=value;
        left = right = null;
    }
}
