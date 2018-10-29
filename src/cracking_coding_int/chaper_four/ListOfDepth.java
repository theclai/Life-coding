package cracking_coding_int.chaper_four;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListOfDepth {
    public static void main(String[] args) {

    }

    ArrayList<LinkedList<TreeNode>> createLevelLinkedlist(TreeNode root) {
        int level = 0;
        return helper(root, new ArrayList<LinkedList<TreeNode>>(), level);
    }

    private ArrayList<LinkedList<TreeNode>> helper(TreeNode root,
                                                   ArrayList<LinkedList<TreeNode>> linkedLists,
                                                   int level) {
        if (root==null) return null;
        LinkedList list=null;
        if(level==linkedLists.size()){
            list=new LinkedList<TreeNode>();
            linkedLists.add(list);
            list.add(root);
        }else{
            list=linkedLists.get(level);
        }
        list.add(root);
        helper(root.left,linkedLists,level+1);
        helper(root.right,linkedLists,level+1);
        return linkedLists;
    }
}
