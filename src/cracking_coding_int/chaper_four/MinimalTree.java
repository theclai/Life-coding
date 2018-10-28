package cracking_coding_int.chaper_four;

import tree.TreeNode;

public class MinimalTree {
    public static void main(String[] args) {
        int[] array=new int[]{1,2,3,4,5,6,7,8,9,10};
        TreeNode node=createMinBST(array);
        System.out.println(node.val);
    }

    private static TreeNode createMinBST(int[] array) {
        return helper(array,0,array.length-1);
    }

    private static TreeNode helper(int[] array, int start, int end) {
        if(start>end)
            return null;

        int mid=(start+end)/2;
        // left
        TreeNode treeNode=new TreeNode(array[mid]);
        treeNode.left=helper(array,start,mid-1);
        treeNode.right=helper(array,mid+1,end);
        return treeNode;
    }
}
