package leetcode.binary_tree;

public class InOrderTraversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public static void main(String[] args){
        TreeNode root= new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right= new TreeNode(5);
        System.out.println("Inorder Traversal: ");
        inOrderTraversal(root);
        System.out.println();

        System.out.println("Pre-Order Traversal: ");
        preOrderTraversal(root);
        System.out.println();

        System.out.println("Post-Order Traversal: ");
        postOrderTraversal(root);
        System.out.println();

    }

    private static void postOrderTraversal(TreeNode root) {
        if(root==null)
            return;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.val+"->");
    }

    public static void inOrderTraversal(TreeNode root){
        if(root==null)
            return;
        inOrderTraversal(root.left);
        System.out.print(root.val+"->");
        inOrderTraversal(root.right);
    }

    public static void preOrderTraversal(TreeNode node){
        if(node==null)
            return;
        System.out.print(node.val+"->");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);

    }
}
