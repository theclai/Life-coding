package data_structure.trees;

import java.util.Arrays;

public class SegmentTree {
    public static void main(String[] args) {
        int[] in = new int[]{1,5,3,7,3,2,5,7,5};
        SegmentTree st = new SegmentTree();
        int[] result = st.buildTree(in);
        Arrays.stream(result).forEach(i-> System.out.println(i));
    }

    public int[] buildTree(int[] arr) {
        int n = arr.length;
        int[] data = new int[2 * n];
        for (int j = 0; j < n; j++)
            data[n + j] = arr[j];
        for (int i = n - 1; i >= 1; i--) {
            data[i] = Math.min(data[2 * i], data[(2 * i)+1]);
        }
        return data;
    }

}
