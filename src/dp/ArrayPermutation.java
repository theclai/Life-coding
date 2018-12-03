package dp;

import java.util.ArrayList;
import java.util.List;

public class ArrayPermutation {
    public static void main(String[] args) {
        int[] input = {1, 2, 3};

        permulationOfArray(input);
    }

    private static void permulationOfArray(int[] input) {
        List<int[]> result = permutehelper(input, new ArrayList<int[]>(), 0);
        System.out.println(result.size());
    }

    private static List<int[]> permutehelper(int[] a,
                                             ArrayList<int[]> result,
                                             int start) {
        if (start >= a.length) {
            result.add(a.clone());
            for (int j = 0; j < a.length; j++) {
                System.out.print(a[j]);
            }
            System.out.println("");
            System.out.println("*****---****");
        }

        for (int i = start; i < a.length; i++) {
            swap(a, start, i);
            permutehelper(a, result, start + 1);
            swap(a, i, start);
        }
        return result;
    }

    private static void swap(int[] input, int i, int j) {
        int temp = input[j];
        input[j] = input[i];
        input[i] = temp;
    }
}
