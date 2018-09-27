package leetcode.binary_tree;

import leetcode.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class InOrderTraversalWithoutRecursion {
    public static TreeNode root;

    public static void main(String[] args) {
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        traverseInorderWithoutRecusion(root);

    }

    private static List<Integer> traverseInorderWithoutRecusion(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque();
        TreeNode curr = root;
        List<Integer> result = new ArrayList<>();
        while (!deque.isEmpty() || curr != null) {
            if (curr != null) {
                deque.addFirst(curr);
                if (curr.left != null)
                    System.out.println(curr.val + "->left: " + curr.left.val);
                curr = curr.left;
            } else {
                curr = deque.removeFirst();
                if (curr.right != null)
                    System.out.println(curr.val + "->right: " + curr.right.val);
                result.add(curr.val);
                curr = curr.right;
            }
        }
        return result;

    }
}
