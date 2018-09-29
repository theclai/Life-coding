package leetcode.binary_tree;

import leetcode.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/***
 *
 *          1
 *        /   \
 *       2     3
 *     /  \  /  \
 *    4   5 6   7
 *
 * */

public class PreorderTraversalWithoutRecursion {
    public static TreeNode root;

    public static void main(String[] args) {
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        traversePreorderWithoutRecusion(root);

    }

    private static List<Integer> traversePreorderWithoutRecusion(TreeNode root) {
        Deque<TreeNode> stack=new ArrayDeque<>();

        List<Integer> result=new ArrayList<>();

        stack.addFirst(root);
        while (!stack.isEmpty()){
            TreeNode curr=stack.removeFirst();
            result.add(curr.val);

            // You need add left later becasue of the stack structure.
            if(curr.right!=null){
                stack.addFirst(curr.right);
            }

            // Last add first out, left will pop before right
            if(curr.left!=null){
                stack.addFirst(curr.left);
            }
        }

        return result;
    }
}
