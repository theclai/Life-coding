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
        for (int i = 0; i < n; i++)
            root = insert(root, intervals[i]);

        System.out.println(root);

    }

    private static IntrvalTree insert(IntrvalTree root,
                                      int[] interval) {
        if (root == null) {
            root = new IntrvalTree(interval[0], interval[1]);
            root.setMax(interval[1]);
            return root;
        }
        int high = interval[1];
        if (high >= root.getMax()) {
            root.right = insert(root.right, interval);
        } else {
            root.left = insert(root.left, interval);
        }
        if (root.max < high)
            root.max = high;
        return root;
    }

    private static boolean doOVerlap(int[] interval1, int[] interval2) {
        int i1Low=interval1[0];
        int i1High=interval1[1];

        int i2Low=interval2[0];
        int i2High=interval2[1];
        if (i1Low < i2High && i2Low < i1High)
            return true;
        return false;
    }
}
