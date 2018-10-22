package dp;

import java.util.Arrays;

/***
 * https://www.geeksforgeeks.org/longest-increasing-subsequence-dp-3/
 *
 *Let us discuss Longest Increasing Subsequence (LIS) problem as an example problem that can be solved using Dynamic Programming.
 * The Longest Increasing Subsequence (LIS) problem is to find the length of the longest subsequence of a given sequence such that all elements of the subsequence are sorted in increasing order. For example, the length of LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80} is 6 and LIS is {10, 22, 33, 50, 60, 80}.
 * longest-increasing-subsequence
 *
 * More Examples:
 *
 * Input  : arr[] = {3, 10, 2, 1, 20}
 * Output : Length of LIS = 3
 * The longest increasing subsequence is 3, 10, 20
 *
 * Input  : arr[] = {3, 2}
 * Output : Length of LIS = 1
 * The longest increasing subsequences are {3} and {2}
 *
 * Input : arr[] = {50, 3, 10, 7, 40, 80}
 * Output : Length of LIS = 4
 * The longest increasing subsequence is {3, 7, 40, 80}
 * */
public class LIS {
    public static void main(String[] args) {
        int[] input = new int[]{3, 10, 2, 1, 20};
        System.out.println(findLIS(input));
    }

    private static int findLIS(int[] input) {
        if (input == null || input.length == 0)
            return 0;

        int[] max = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            max[i] = 1; // Default value is 1 since each number is a lis for length 1
            for (int j = 0; j < i; j++) {
                if (input[i] > input[j]) {
                    max[i] = Math.max(max[j] + 1, max[i]);
                }
            }
        }
        return Arrays.stream(max).max().getAsInt();
    }
}
