package strings;

import java.util.Arrays;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * <p>
 * Example 1:
 * <p>
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 * <p>
 * Input: "cbbd"
 * Output: "bb"
 * <p>
 * we need to build a matrix by input and reverse of the input. Like below
 * *** b a b a d
 * ----------------
 * d | 0 0 0 0 1
 * a | 0 1 0 1 0
 * b | 1 0 2 0 0
 * a | 0 2 0 3 0
 * b | 1 0 3 0 0
 */

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String input1 = "cbbd";
        String input2 = reverseString(input1);
        System.out.println(input1 + "-->" + input2);

        System.out.println(findLongestPanlindrom(input1, reverseString(input1)));
    }

    private static String findLongestPanlindrom(String input1, String input2) {
        char[] rows = input1.toCharArray();
        char[] cols = input2.toCharArray();
        int row = rows.length;
        int col = input2.length();
        int[][] cache = new int[row][col];
        int maxPos = 0;
        int max = 0;
        if (row == 0 || col == 0)
            max = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (cols[j] == rows[i]) {
                    if (i > 0 && j > 0) {
                        cache[i][j] = cache[i - 1][j - 1] + 1;
                    } else {
                        cache[i][j] = 1;

                    }
                    if (cache[i][j] > max){
                        max = cache[i][j];
                        maxPos=i;
                    }
                }
            }
        }

        System.out.println("Max Position: " + maxPos);
        System.out.println("Max Length: " + max);
        return input1.substring(maxPos+1-max,maxPos+1);
    }

    private static String reverseString(String input1) {
        return new StringBuilder(input1).reverse().toString();
    }
}
