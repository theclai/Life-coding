package leetcode.binary_tree;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class AllPossibleBinaryTree {
    public List<TreeNode> allPossibleFBT(int N) {
        return helper(N-1,new TreeNode(0),new ArrayList<TreeNode>());
    }

    public List<TreeNode> helper(int N,TreeNode root, ArrayList<TreeNode> nodes){
        if(root==null){
            return nodes;
        }
        nodes.add(root);

        if(N>=0){
            root.left=new TreeNode(0);
            root.right=new TreeNode(0);
            helper(N-2,root.left,nodes);
            helper(N-2,root.right,nodes);

        }else{
            root.left=null;
            root.right=null;
            helper(N,root.left,nodes);
            helper(N,root.right,nodes);
        }
        return nodes;
    }
}
