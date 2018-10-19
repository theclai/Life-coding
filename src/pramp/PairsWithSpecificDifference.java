package pramp;

import java.util.HashMap;
/**
 * Pairs with Specific Difference
 * Given an array arr of distinct integers and a nonnegative integer k, write a function findPairsWithGivenDifference that returns an array of all pairs [x,y] in arr, such that x - y = k. If no such pairs exist, return an empty array.
 *
 * Note: the order of the pairs in the output array should maintain the order of the y element in the original array.
 *
 * Examples:
 *
 * input:  arr = [0, -1, -2, 2, 1], k = 1
 * output: [[1, 0], [0, -1], [-1, -2], [2, 1]]
 *
 * input:  arr = [1, 7, 5, 3, 32, 17, 12], k = 17
 * output: []
 * */
public class PairsWithSpecificDifference {
    public static void main(String[] args) {
        int[] input = new int[]{0, -1, -2, 2, 1};
        int target = 1;

        /*int[] input=new int[]{1, 7, 5, 3, 32, 17, 12};
        int target=17;*/
        findSpecificDifference(input, target);
    }

    private static void findSpecificDifference(int[] input, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < input.length; i++) {
            int number = input[i];
            int diff;
            diff = number - (k);
            map.put(diff,number);
        }
        for (int i = 0; i < input.length; i++) {
            int number = input[i];

            if (map.containsKey(number)) {
                System.out.print(  map.get(number)+ " -> " +number);
                System.out.println("");
            }
        }

    }
}
