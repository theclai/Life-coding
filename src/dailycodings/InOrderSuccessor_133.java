package dailycodings;

import leetcode.TreeNode;

public class InOrderSuccessor_133 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.parent = null;
        construct(root);
        TreeNode res = findSuccessor(root, 22);
        System.out.println(res.val);
        TreeNode res1 = findSuccessor(root, 5);
        System.out.println(res1.val);
    }

    private static TreeNode findSuccessor(TreeNode root, int n) {
        TreeNode succ = null;
        while (true) {
            if (n < root.val) {
                succ = root;
                root = root.left;
            } else if (n > root.val) {
                root = root.right;
            } else {
                if (root.right != null)
                    succ = findMin(root.right);
                break;
            }
        }
        return succ;
    }

    public static TreeNode findMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    private static void construct(TreeNode root) {
        TreeNode five = new TreeNode(5);
        five.parent = root;
        root.left = five;

        TreeNode thirty = new TreeNode(30);
        TreeNode twentyTwo = new TreeNode(22);
        twentyTwo.parent = thirty;
        thirty.left = twentyTwo;
        TreeNode thirtyFive = new TreeNode(35);
        thirtyFive.parent = thirty;
        thirty.right = thirtyFive;
        thirty.parent = thirty;
        root.right = thirty;

    }
}
