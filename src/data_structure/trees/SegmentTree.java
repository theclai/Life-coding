package data_structure.trees;

import java.util.Arrays;

public class SegmentTree {
    static int[] tree;
    static int n;

    public static void main(String[] args) {
        int[] in = new int[]{1, 5, 3, 7, 3, 2, 5, 7, 5};
        n = in.length;
        SegmentTree st = new SegmentTree();
        tree = st.buildTree(in);
        st.update(0,2);
        Arrays.stream(tree).forEach(i -> System.out.println(i));
    }

    public int[] buildTree(int[] arr) {
        int[] data = new int[2 * n];
        for (int j = 0; j < n; j++)
            data[n + j] = arr[j];
        for (int i = n - 1; i >= 1; i--) {
            data[i] = Math.min(data[2 * i], data[(2 * i) + 1]);
        }
        return data;
    }

    public int query(int[] tree, int left, int right) {

        return 0;
    }

    public void update(int idx, int val) {
        idx = idx + n;
        tree[idx] = val;
        while (idx>1){
            idx=idx/2;
            tree[idx]=Math.min(tree[2*idx],tree[2*idx+1]);
        }
    }

}
