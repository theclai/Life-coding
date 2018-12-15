package leetcode;

public class InsertIntoBst {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        return helper(root,val);
    }

    private TreeNode helper(TreeNode root, int val) {
        if(root==null)
            return new TreeNode(val);
        else{
            if(val>root.val)
                root.right= helper(root.right,val);
            else
                root.left= helper(root.left,val);
        }
        return root;
    }
}
