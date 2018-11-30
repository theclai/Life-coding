package leetcode;

/**
 * S and T are strings composed of lowercase letters. In S, no letter occurs more than once.
 * <p>
 * S was sorted in some custom order previously. We want to permute the characters of T so that they match the order that S was sorted. More specifically, if x occurs before y in S, then x should occur before y in the returned string.
 * <p>
 * Return any permutation of T (as a string) that satisfies this property.
 * <p>
 * Example :
 * Input:
 * S = "cba"
 * T = "abcd"
 * Output: "cbad"
 * Explanation:
 * "a", "b", "c" appear in S, so the order of "a", "b", "c" should be "c", "b", and "a".
 * Since "d" does not appear in S, it can be at any position in T. "dcba", "cdba", "cbda" are also valid outputs.
 */
public class CustomSortString_791 {
    public static void main(String[] args) {

        CustomSortString_791 cs=new CustomSortString_791();
        cs.customSortString("cba","abcd");
    }

    public String customSortString(String S, String T) {
        // Step 1: count the freq of each char in T
        //
        int[] freq = new int[26];

        for (int i = 0; i < T.length(); i++) {
            char c = T.charAt(i);
            freq[c - 'a']++;
        }

        // step 2: scan the string S and print the number of chars in T
        //
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);

            while (freq[c - 'a'] > 0) {
                sb.append(c);
                freq[c - 'a']--;
            }
        }

        // step 3: scan the freq again and append anything not zero
        //
        for (int i = 0; i < freq.length; i++) {
            while (freq[i] > 0) {
                sb.append((char) (i + 'a'));
                freq[i]--;
            }
        }

        return sb.toString();
    }
}
