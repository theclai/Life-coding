package leetcode;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        merge(new int[]{1, 2, 3, 0, 0, 0}, 3,
                new int[]{2, 5, 6}, 3);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] out = new int[m + n];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < m || j < n) {
            if (i >= m)
                out[k++] = nums2[j++];
            else if (j >= n)
                out[k++] = nums1[i++];
            else if (i < m && j < n) {
                if (nums1[i] <= nums2[j])
                    out[k++] = nums1[i++];
                else
                    out[k++] = nums2[j++];
            }
        }

        Arrays.stream(out).forEach(val -> System.out.println(val));

    }
}
