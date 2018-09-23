package leetcode.binary_tree;

public class InorderPostorderToBT {
    static int postIndex = 0;

    public static void main(String[] args) {
        int in[] = new int[]{4, 8, 2, 5, 1, 6, 3, 7};//LDR
        int post[] = new int[]{8, 4, 5, 2, 6, 7, 3, 1};//LRD
        int n = in.length;
        postIndex = n;
        TreeNode node = buildTree(in, post);
        System.out.println(node.val);
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTreeHelper(inorder, postorder, postIndex - 1, 0);
    }

    public static TreeNode buildTreeHelper(int[] in, int[] post, int start, int end) {
        if (start < end)
            return null;
        TreeNode root = new TreeNode(post[start]);
        postIndex = postIndex - 1;
        if (start == end) {
            return root;
        }
        int index = search(in, start, end, root.val);
        System.out.println(index);
        root.left = buildTreeHelper(in, post, index, 0);
        root.right = buildTreeHelper(in, post, index + 1, post.length);
        return root;
    }

    private static int search(int[] in, int start, int end, int val) {
        int index = 0;
        for (int i = start; i < in.length; i++) {
            if (in[i] == val) {
                index = i;
            }
        }
        return index;
    }
}
