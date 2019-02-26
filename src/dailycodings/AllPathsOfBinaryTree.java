package dailycodings;

import leetcode.TreeNode;

import java.util.ArrayList;

public class AllPathsOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        ArrayList list = new ArrayList();
        list.add(root.data);
        findPaths(root, list);
    }

    private static void findPaths(TreeNode root, ArrayList<Integer> integers) {
        if (root.left == null && root.right == null) {
            printResult(integers);
            integers.remove(integers.size() - 1);
            return;
        }
        if (root.left != null) {
            integers.add(root.left.data);
            findPaths(root.left, integers);
        }
        if (root.left != null) {
            integers.add(root.right.data);
            findPaths(root.right, integers);
        }
    }

    private static void printResult(ArrayList<Integer> integers) {
        integers.stream().forEach(v -> System.out.print(v));
        System.out.println("");
    }
}
