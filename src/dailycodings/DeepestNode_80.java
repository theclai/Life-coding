package dailycodings;

import leetcode.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DeepestNode_80 {
    TreeNode root;
    int deep=-1;
    TreeNode deepest;
    DeepestNode_80 dn;
    @BeforeEach
    public void init() {
        root = new TreeNode('a');
        root.left = new TreeNode('b');
        root.right = new TreeNode('c');
        root.left.left=new TreeNode('d');
        dn=new DeepestNode_80();
    }

    @Test
    public void test(){
        Assertions.assertEquals('d',dn.deepestNode(root).val);

    }

    public TreeNode deepestNode(TreeNode root){
         helper(root,0);
         return deepest;
    }

    private void helper(TreeNode root, int i) {
        if(root==null) return;
        if(i>deep) {
            deep = i;
            deepest=root;
        }
        if(root.left!=null )
            helper(root.left,i+1);
        if(root.right!=null)
            helper(root.right,i+1);
        //return helper(root.left,i+1)||helper(root.right,i+1);
    }
}
