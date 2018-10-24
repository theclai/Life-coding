package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SegmentTree {
    private int n; //number of elements in the arrays
    private ArrayList<Integer> data;
    int[] st;

    public SegmentTree(int[] arr, int n) {
        // Since segment tree is a complete binary tree, it will have total n+n-1=2n-1 nodes
        // memory required
        // Allocate memory for segment tree
        //Height of segment tree
        int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));

        //Maximum size of segment tree
        int max_size = 2 * (int) Math.pow(2, x) - 1;

        st = new int[max_size]; // Memory allocation
        constructorUtil(arr, 0, n - 1, 0);
    }

    /**
     * @param ss start
     * @param se end position
     * @param si position in new array
     */
    private int constructorUtil(int[] arr, int ss, int se, int si) {
        System.out.println("start: " + ss + " end: " + se + "new location: " + si);
        // sum when you are at leaf
        if (ss == se) {
            st[si] = arr[ss];
            return arr[ss];
        }

        // keep doing half and adding
        int mid = getMid(ss, se);
        st[si] = constructorUtil(arr, ss, mid, si * 2 + 1) +
                constructorUtil(arr, mid + 1, se, 2 * si + 2);
        return st[si];
    }

    private int getMid(int ss, int se) {
        return (se - ss) / 2 + ss;
    }

    public static void main(String[] args) {
        SegmentTree st = new SegmentTree(new int[]{1, 3, 5, 7, 9, 11}, 6);
        /*
        for (int i = 0; i < 5; i++) {
            System.out.println(st.minimum(i, i+1));
        }
        System.out.println(st.minimum(i, i+1));

        System.out.println(st.minimum(1, 4));
        st.update(3, 10);
        System.out.println(st.minimum(1, 4));
        System.out.println(st.minimum(0, 5));
        st.update(4, 0);
        System.out.println(st.minimum(1, 4));
        System.out.println(st.minimum(0, 5));*/
    }
}
