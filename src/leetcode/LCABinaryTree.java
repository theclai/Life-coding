package leetcode;

public class LCABinaryTree {

    static TreeNode root;

    public static void main(String[] args) {
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        TreeNode node = lca(root, 4, 7);
        System.out.println(node.data);
    }

    private static TreeNode lca(TreeNode root, int n1, int n2) {
        if (root == null)
            return null;

        if (root.data == n1 || root.data == n2)
            return root;

        TreeNode left = lca(root.left, n1, n2);

        TreeNode right = lca(root.right, n1, n2);

        if (left != null && right != null)
            return root;
        if (left == null && right == null)
            return null;

        return left != null ? left : right;

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;

        if (root.val == p.val || root.val == q.val)
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);

        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null)
            return root;
        if (left == null && right == null)
            return null;

        return left != null ? left : right;
    }

    public TreeNode lcaAlternativeApproach(TreeNode node0, TreeNode node1) {
        // Get the depth
        int depth0 = getDepth(node0);
        int depth1 = getDepth(node1);

        TreeNode shallow=node0;
        TreeNode deep=node1;
        if(depth0>depth1){
            shallow=node0;
            deep=node1;
        }else {
            shallow=node1;
            deep=node0;
        }

        // deep move up to come to the shallow level
        int diff = Math.abs(depth0-depth1);

        if(diff>0){
            while (diff-->0){
                deep=deep.parent;
            }
        }

        // now both node start move up until they meet
        while (shallow!=deep){
            shallow=shallow.parent;
            deep=deep.parent;
        }
        return shallow;

    }

    private int getDepth(TreeNode node) {
        if (root == null)
            return 0;
        int depth = 0;
        while (node.parent != null) {
            depth++;
            node = node.parent;
        }
        return depth;
    }
}
