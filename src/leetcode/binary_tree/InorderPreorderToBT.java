package leetcode.binary_tree;

public class InorderPreorderToBT {
    public static void main(String[] args) {
        char[] in = new char[]{'D', 'B', 'E', 'A', 'F', 'C'};
        char[] pre = new char[]{'A', 'B', 'D', 'E', 'C', 'F'};

        buildTree(in, pre);
    }

    private static void buildTree(char[] in, char[] pre) {
         buildHelper(in,pre,0,in.length-1);
    }

    private static void buildHelper(char[] in,char[] pre,int start,int end) {
        char val=pre[0];
        TreeNode root=new TreeNode(val);
        root.left=search(in,start,end,val);
        root.
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
