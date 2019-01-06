package leetcode.contests;

import java.util.ArrayList;
import java.util.List;

public class PancakeSorting_969 {
    public static void main(String[] args) {
        int[] in = new int[]{3, 2, 4, 1};
        ArrayList<Integer> op= (ArrayList<Integer>) pancakeSort(in);
        op.forEach(val-> System.out.println(val));
    }

    public static List<Integer> pancakeSort(int[] A) {
        int pos = A.length - 1;
        ArrayList<Integer> result = new ArrayList<>();
        while (pos > 0) {
            int maxPos = findMax(A, pos + 1);
            result.add(maxPos+1);
            flip(A, maxPos);
            flip(A, pos);
            pos--;
        }
        return result;
    }

    private static int findMax(int[] arr, int index) {
        int max = Integer.MIN_VALUE;
        int maxPos = -1;
        for (int i = 0; i < index; i++) {
            if (arr[i] >= max) {
                max = arr[i];
                maxPos = i;
            }
        }
        return maxPos;
    }

    private static void flip(int[] arr, int end) {
        int start = 0;
        while (start < end) {
            int temp= arr[start];
            arr[start] = arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }
}
