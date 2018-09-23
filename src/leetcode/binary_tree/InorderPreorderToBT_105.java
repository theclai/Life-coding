package leetcode.binary_tree;

public class InorderPreorderToBT_105 {
    static int preIndex=0;
    public static void main(String[] args) {
        char[] in = new char[]{'D', 'B', 'E', 'A', 'F', 'C'};//LDR
        char[] pre = new char[]{'A', 'B', 'D', 'E', 'C', 'F'};//DLR

        buildTree(in, pre);
    }

    private static TreeNode buildTree(char[] in, char[] pre) {
        return buildHelper(in, pre, 0, in.length - 1);
    }

    private static TreeNode buildHelper(char[] in,
                                        char[] pre,
                                        int start,
                                        int end) {
        if (end < start) {
            return null;
        }
        TreeNode root=new TreeNode(pre[preIndex++]);
        if (start == end) {
            return root;
        }
        int searchOutput = search(in, start, end, root.data);
        root.left = buildHelper(in, pre, start, searchOutput - 1);
        root.right = buildHelper(in, pre, searchOutput + 1, end);
        return root;
    }

    static int search(char arr[], int strt, int end, char value) {
        int i;
        for (i = strt; i <= end; i++) {
            if (arr[i] == value)
                return i;
        }
        return i;
    }
}
