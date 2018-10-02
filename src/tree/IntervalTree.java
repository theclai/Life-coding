package tree;

public class IntervalTree {
    static class IntrvalTree {
        int low;
        int high;
        int max;
        IntrvalTree left, right;

        public IntrvalTree(int low, int high) {
            this.low = low;
            this.high = high;
        }

        public int getLow() {
            return low;
        }

        public void setLow(int low) {
            this.low = low;
        }

        public int getHigh() {
            return high;
        }

        public void setHigh(int high) {
            this.high = high;
        }

        public int getMax() {
            return max;
        }

        public void setMax(int max) {
            this.max = max;
        }

        public IntrvalTree getLeft() {
            return left;
        }

        public void setLeft(IntrvalTree left) {
            this.left = left;
        }

        public IntrvalTree getRight() {
            return right;
        }

        public void setRight(IntrvalTree right) {
            this.right = right;
        }
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{15, 20}, {10, 30}, {17, 19},
                {5, 20}, {12, 15}, {30, 40}
        };
        int n = intervals.length;
        IntrvalTree root = null;
        for (int i = 0; i < n; i++) {
            IntrvalTree intrvalTree = new IntrvalTree(intervals[i][0], intervals[i][1]);
            root = insert(root, intrvalTree);
        }

        System.out.println(root);
        System.out.println(overlapSearch(root,new IntrvalTree(17,19)));

    }

    private static IntrvalTree insert(IntrvalTree root,
                                      IntrvalTree intrvalTree) {
        if (root == null) {
            root = intrvalTree;
            root.setMax(intrvalTree.high);
            return root;
        }
        if (intrvalTree.high >= root.getMax()) {
            root.right = insert(root.right, intrvalTree);
        } else {
            root.left = insert(root.left, intrvalTree);
        }
        if (root.max < intrvalTree.high)
            root.max = intrvalTree.high;
        return root;
    }

    public static IntrvalTree overlapSearch(IntrvalTree root, IntrvalTree intrvalTree) {
        // Base Case, tree is empty
        if (root == null) return null;

        // If given interval overlaps with root
        if (doOVerlap(root, intrvalTree)) {
            root = intrvalTree;
            return root;
        }

        // If left child of root is present and max of left child
        // is greater than or equal to given interval, then i may
        // overlap with an interval is left subtree
        if (root.left != null && root.left.max >= intrvalTree.low) {
            return overlapSearch(root.left, intrvalTree);
        }

        // Else interval can only overlap with right subtree
        return overlapSearch(root.right, intrvalTree);
    }

    private static boolean doOVerlap(IntrvalTree interval1, IntrvalTree interval2) {
        if (interval1.low < interval2.high && interval2.low < interval1.high)
            return true;
        return false;
    }
}
