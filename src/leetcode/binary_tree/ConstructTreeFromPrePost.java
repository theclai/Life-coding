package leetcode.binary_tree;


import java.util.Arrays;

/***
 * Tree to construct
 *
 *           1
 *          / \
 *        2     3
 *       / \   / \
 *      4   5  6  7
 * */

public class ConstructTreeFromPrePost {
    static int[] pre = {1, 2, 4, 5, 3, 6, 7};
    static int[] post = {4, 5, 2, 6, 7, 3, 1};

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

    }

    public static void main(String[] args) {
        constructTree(pre, post);
    }

    private static TreeNode constructTree(int[] pre, int[] post) {
        printArray("Pre: ",pre);
        printArray("Post: ",post);
        System.out.println("");

        int N = pre.length;
        if (N == 0) {
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        if (N == 1)
            return root;
        int L = 0;
        L = findL(pre[1], post);
        root.left = constructTree(
                Arrays.copyOfRange(pre, 1, L+1),
                Arrays.copyOfRange(post, 0, L));

        root.right = constructTree(
                Arrays.copyOfRange(pre,L+1,N),
                Arrays.copyOfRange(post,L,N-1)
        );
        return root;
    }

    private static void printArray(String s, int[] data) {
        System.out.print(s);
        for(int i=0;i<data.length;i++){
            System.out.print(data[i]+" ");
        }

    }

    private static int findL(int t, int[] post) {
        for (int i = 0; i < post.length; ++i) {
            if (t == post[i])
                return (i + 1);
        }
        return 0;
    }
}
