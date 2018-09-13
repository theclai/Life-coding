package leetcode;

public class Pathsum {
    Node root;

    public static void main(String args[])
    {
        int sum = 21;

        /* Constructed binary tree is
              10
             /  \
           8     2
          / \   /
         3   5 2
        */
        Pathsum tree = new Pathsum();
        tree.root = new Node(10);
        tree.root.left = new Node(8);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(2);

        if (hasPathSum(tree.root, sum))
            System.out.println("There is a root to leaf path with sum " + sum);
        else
            System.out.println("There is no root to leaf path with sum " + sum);
    }
    static int tempsum=0;
    static class Node {
        int val;
        Node left;
        Node right;

        Node(int x) {
            val = x;
        }
    }

    public static boolean hasPathSum(Node root, int sum) {
        if(sum==compute(root,0)){
            return true;
        }
        return false;

    }

    private static int compute(Node root,int tempsum) {
        if(root==null){
            return tempsum;
        }
        int t=tempsum+root.val;
        if(t==84){
            System.out.println("Found");
            return t;
        }
        if(root.left!=null)
             compute(root.left,t);
        if(root.right!=null)
            return compute(root.right,t);
        return t;
    }
}
