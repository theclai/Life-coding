package leetcode;

import java.util.Arrays;

public class ProductOfArrayExceptSelf_238 {
    public static void main(String[] args) {
        ProductOfArrayExceptSelf_238 paes = new ProductOfArrayExceptSelf_238();
        //int[] input = new int[]{1, 2, 3, 4};
        int[] input=new int[]{2,3,5,0};
        paes.product(input);
    }

    private int[] product(int[] input) {
        if (input == null || input.length == 0) return new int[0];
        int[] result = new int[input.length];
        result[0] = (input[0] == 0) ? 0 : 1;
        result[1] = input[0];

        for (int i = 2; i < input.length; i++) {
            result[i] = result[i - 1] * input[i - 1];
        }
        Arrays.stream(result).forEach(op -> System.out.println(op));

        int beforeLast = input[input.length - 1];
        result[input.length - 1] = result[input.length - 1];
        result[input.length - 2] = result[input.length - 2] * beforeLast;
        int j = input.length - 3;
        while (j >= 0) {
            beforeLast = beforeLast * input[j + 1];
            result[j] = beforeLast * result[j];
            j--;
        }
        Arrays.stream(result).forEach(op -> System.out.println(op));
        return result;
    }
}
