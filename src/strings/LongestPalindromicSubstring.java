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
        String input1 = "babad";
        String input2 = reverseString(input1);
        System.out.println(input1 + "-->" + input2);
    }

    private static String reverseString(String input1) {
        char[] op = new char[input1.length()];
        int i = 0;
        while (i < input1.length()) {
            op[i] = input1.charAt(input1.length() - i - 1);
            i++;
        }
        return Arrays.toString(op);
    }
}
