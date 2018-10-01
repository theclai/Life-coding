package cracking_coding_int;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ListOfDepths {
    private static TreeNode root;

    public static void main(String[] args) {
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        System.out.println(findDepth(root));
    }

    private static List<LinkedList<TreeNode>> findDepth(TreeNode root) {
        // need to do a breadth first search
        List<LinkedList<TreeNode>> result = new ArrayList<>();
        LinkedList<TreeNode> current = new LinkedList<>();
        if (root != null)
            current.add(root);
        int level = 0;
        while (current.size() > 0) {
            result.add(current);
            // go to next level
            LinkedList<TreeNode> parents = current;
            current = new LinkedList<>();

            // add all the nodes to a linkedlist
            // iterate all the childs of the list
            for (TreeNode parent : parents) {
                // visit children
                if (parent.left != null) {
                    current.add(parent.left);
                }
                if (parent.right != null) {
                    current.add(parent.right);
                }
            }
        }
        return result;
    }
}
