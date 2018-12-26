package practice;

public class IntervalTree {
    private static class ITNode {
        int max;
        int low, high;
        ITNode left, right;

        public ITNode(int low, int high) {
            this.max = high;
            this.low = low;
            this.high = high;
            this.left = null;
            this.right = null;
        }
    }

    public static ITNode insert(ITNode root, ITNode newNode) {
        if (root == null) return newNode;
        if (newNode.low < root.low)
            root.left = insert(root.left, newNode);
        else
            root.right = insert(root.right, newNode);

        if (root.max < newNode.high)
            root.max = newNode.high;
        return root;
    }

    public static void inOrder(ITNode root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.println("Low: " + root.low + " High: " + root.high + " Max: " + root.max);
        inOrder(root.right);
    }

    public static boolean doOverlap(ITNode node1, ITNode node2) {
        if (node1.low < node2.high && node2.low < node1.high)
            return true;
        return false;
    }

    public static ITNode overlapSearch(ITNode root, ITNode search) {
        if (root == null) return null;
        if (doOverlap(root, search)) return root;
        // If left child of root is present and max of left child is
        // greater than or equal to given interval, then i may
        // overlap with an interval is left subtree
        if (root.left != null && root.left.max > search.low)
            return overlapSearch(root.left, search);
        return overlapSearch(root.right, search);

    }

    public static void main(String[] args) {
        ITNode root = null;
        int[][] data = new int[][]{{15, 20}, {10, 30}, {17, 19},
                {5, 20}, {12, 15}, {30, 40}};
        for (int i = 0; i < data.length; i++) {
            int low = data[i][0];
            int high = data[i][1];
            ITNode node = new ITNode(low, high);
            root = insert(root, node);
        }

        inOrder(root);

        ITNode search=new ITNode(6,7);
        ITNode result=overlapSearch(root,search);
        System.out.println("Low: "+result.low+" High: "+result.high);

    }
}
