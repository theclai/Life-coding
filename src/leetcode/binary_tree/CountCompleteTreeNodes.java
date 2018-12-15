package leetcode.binary_tree;

import leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        int count = 0;
        while(!q.isEmpty()){
            TreeNode temp = q.poll();
            count++;
            if(temp.val!=-1){
                temp.val=-1;

                if(temp.left!=null){
                    q.offer(temp.left);
                }

                if(temp.right!=null){
                    q.offer(temp.right);
                }
            }
        }
        return count;
    }

}
