package dailycodings;

import leetcode.TreeNode;

public class BTFromPreAndIn {
    public static void main(String[] args) {
        char[] in = new char[]{};
        char[] pre = new char[]{};
        buildBT(in, pre, 0, in.length);
    }

    private static TreeNode buildBT(char[] in, char[] pre, int start, int end) {
        if (start > end) return null;
        TreeNode tn = new TreeNode(pre[start]);
        if (start == end)
            return tn;
        int index = search(in, start, end, tn.c);
        tn.left = buildBT(in, pre, start, index - 1);
        tn.right = buildBT(in, pre, index + 1, end);
        return tn;
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
