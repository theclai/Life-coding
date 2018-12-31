package pramp;

import java.util.Arrays;

public class PancakeSort {
    static int[] pancakeSort(int[] arr) {
        int i = arr.length;
        int len = arr.length;
        while (i >= 0) {
            int pos = max(arr, 0, len);
            flip(arr, pos);
            flip(arr, len - 1);
            len--;
            i--;
        }
        return arr;
    }

    public static void flip(int[] arr, int k) {
        int i = 0;
        int j = k;
        while (i < k) {
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
            i++;j--;
        }
    }

    public static int max(int[] arr, int start, int end) {
        int max = Integer.MIN_VALUE;
        int maxPosition = 0;
        for (int i = start; i < end; i++) {
            if (arr[i] >= max) {
                max = arr[i];
                maxPosition = i;
            }
        }
        return maxPosition;
    }

    public static void main(String[] args) {
        int[] result = pancakeSort(new int[]{1, 5, 4, 3, 2});
        Arrays.stream(result).forEach(val -> System.out.println(val));

    }
}
