package leetcode.binary_tree;

import leetcode.TreeNode;

import java.util.*;

public class BTColumwise {
    TreeMap<Integer, List<Integer>> map;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(9);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);
        root.left.left.right = new TreeNode(0);

        root.right = new TreeNode(4);
        root.right.right = new TreeNode(3);
        root.right.right.left = new TreeNode(7);
        BTColumwise bt = new BTColumwise();
        bt.printColwise(root);
    }

    public void printColwise(TreeNode root) {
        map = new TreeMap<>();
        helper(root, map, 0);
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> list = entry.getValue();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int val = (int) it.next();
                System.out.print(val + "->");
            }
            System.out.println("");
        }
    }

    private void helper(TreeNode root, TreeMap<Integer, List<Integer>> map, int hd) {
        if (root == null) return;
        map.computeIfAbsent(hd, val -> new ArrayList<>()).add(root.val);
        helper(root.left, map, hd - 1);
        helper(root.right, map, hd + 1);
    }

}
