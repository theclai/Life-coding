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
    static int[] tree;

    static int n;

    public SegmentTree(int[] a) {
        n = a.length;
        tree = new int[2 * n];
        // insert leaf nodes in tree
        for (int i = 0; i < n; i++)
            tree[n + i] = a[i];

        // build the tree by calculating
        // parents
        for (int i = n - 1; i > 0; --i)
            tree[i] = tree[i << 1] + // left shift means 2*i
                    tree[i << 1 | 1];// left shit and add 1. 2*i+1
        //Arrays.stream(tree).forEach(System.out::println);
    }

    public int query(int left, int right) {
        // since actual data is in the right side
        // left = left + n;
        //right = right + n;
        int result = 0;
        for (left = left + n, right = right + n; left < right; left >>= 1, right >>= 1) {

            if ((left & 1) > 0) {// AND operations with 1 gives 0 for even number and 1 for odd number
                result += tree[left++];
            }
            if ((right & 1) > 0) {
                result += tree[--right];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        SegmentTree st = new SegmentTree(a);
        //System.out.println(a.length);
        //System.out.println(a.length << 1 | 1);
        System.out.println(st.query(0, 3));

    }
}
