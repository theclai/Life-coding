package tree;
import java.util.Stack;

public class BinaryTreeToFlattenLinkedList {

    public void flatten(TreeNode root) {
        if(root == null) return;

        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        TreeNode prev = null, curr = null;
        while(!s.isEmpty()){
            curr = s.pop();
            if(prev != null) {prev.right = curr; prev.left=null;}
            if(curr.right != null) s.push(curr.right);
            if(curr.left != null) s.push(curr.left);
            prev = curr;
        }
        curr.right = null;

    }
}
