package cracking_coding_int.chapter_one;

import java.util.Arrays;

/***
 * Assume case sensitive
 */

public class CheckPermutation {
    public static void main(String[] args) {
        String a = "dog";
        String b = "god";
        System.out.println(checkPermutation(a, b));

    }

    private static boolean checkPermutation(String a, String b) {
        if (a.length() != b.length())
            return false;

        char[] aChars=a.toCharArray();
        char[] bChars=b.toCharArray();
        Arrays.sort(aChars);
        Arrays.sort(bChars);
        return new String(aChars).equals(new String(bChars));
    }
}
