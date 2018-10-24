package tree;

/**
 * 1. ST is a binary tree. In a tree data stored as
 * parent = i
 * left = 2*i
 * right = 2*i +1
 * <p>
 * 2. In a complete binary tree, for n leaf nodes
 * it will have 2*n-1 nodes
 * <p>
 * 3. We need double size of array
 * 4. Keep origin(since they are leaf in ST) into right half of the tree
 * 5. compute the parents and put into right position based on step-1
 */
public class SegmentTree {
    public static void main(String[] args) {
        SegmentTree st = new SegmentTree(new int[]{1, 3, 5, 7, 9, 11}, 6);
    }
}
