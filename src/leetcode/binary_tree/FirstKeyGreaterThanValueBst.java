package leetcode.binary_tree;

import leetcode.ListNode;

import java.util.ArrayList;
import java.util.List;

public class FirstKeyGreaterThanValueBst {
    static List<TreeNode> list=new ArrayList<>();

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(19);
        root.left = new TreeNode(7);
        root.right = new TreeNode(43);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(11);

        root.right.left = new TreeNode(23);
        root.right.right = new TreeNode(47);

        root.right.left.right = new TreeNode(37);

        root.right.left.right.left = new TreeNode(29);

        TreeNode output = find(root, 23, null);
        System.out.println(output.val);


    }

    private static TreeNode find(TreeNode root, int key, TreeNode result) {
        if (root == null) {
            return root;
        } else {

        }
        System.out.println(root.val);
        list.add(root);
        result = root;
        if (root.val > key) {
            //root=root.left;
            find(root.left, key, result);
        } else {
            //root=root.right;
            find(root.right, key, result);
        }
        return list.get(list.size()-1);

    }
}
