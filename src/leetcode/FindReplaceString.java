package leetcode;

import java.util.*;

/**
 * To some string S, we will perform some replacement operations that replace groups of letters with new ones (not necessarily the same size).
 * <p>
 * Each replacement operation has 3 parameters: a starting index i, a source word x and a target word y.  The rule is that if x starts at position i in the original string S, then we will replace that occurrence of x with y.  If not, we do nothing.
 * <p>
 * For example, if we have S = "abcd" and we have some replacement operation i = 2, x = "cd", y = "ffff", then because "cd" starts at position 2 in the original string S, we will replace it with "ffff".
 * <p>
 * Using another example on S = "abcd", if we have both the replacement operation i = 0, x = "ab", y = "eee", as well as another replacement operation i = 2, x = "ec", y = "ffff", this second operation does nothing because in the original string S[2] = 'c', which doesn't match x[0] = 'e'.
 * <p>
 * All these operations occur simultaneously.  It's guaranteed that there won't be any overlap in replacement: for example, S = "abc", indexes = [0, 1], sources = ["ab","bc"] is not a valid test case.
 * <p>
 * Example 1:
 * <p>
 * Input: S = "abcd", indexes = [0,2], sources = ["a","cd"], targets = ["eee","ffff"]
 * Output: "eeebffff"
 * Explanation: "a" starts at index 0 in S, so it's replaced by "eee".
 * "cd" starts at index 2 in S, so it's replaced by "ffff".
 * Example 2:
 * <p>
 * Input: S = "abcd", indexes = [0,2], sources = ["ab","ec"], targets = ["eee","ffff"]
 * Output: "eeecd"
 * Explanation: "ab" starts at index 0 in S, so it's replaced by "eee".
 * "ec" doesn't starts at index 2 in the original S, so we do nothing.
 * Notes:
 * <p>
 * 0 <= indexes.length = sources.length = targets.length <= 100
 * 0 < indexes[i] < S.length <= 1000
 * All characters in given inputs are lowercase letters.
 */
public class FindReplaceString {
    public static void main(String[] args) {
        String S = "abcd";
        int[] indexes = new int[]{0, 2};
        String[] sources = new String[]{"a", "cd"};
        String[] targets = new String[]{"eee", "ffff"};
        System.out.println(findReplaceString(S, indexes, sources, targets));

        int[] indexes1 = new int[]{0, 2};
        String[] sources1 = new String[]{"ab", "ec"};
        String[] targets1 = new String[]{"eee", "ffff"};
        System.out.println(findReplaceString(S, indexes1, sources1, targets1));

        String S2 = "vmokgggqzp";
        int[] indexes2 = new int[]{3, 5, 1};
        String[] sources2 = new String[]{"kg", "ggq", "mo"};
        String[] targets2 = new String[]{"s", "so", "bfr"};
        System.out.println(findReplaceStringAdvance(S2, indexes2, sources2, targets2));

    }

    public static String findReplaceStringAdvance(String S,
                                                  int[] indexes,
                                                  String[] sources,
                                                  String[] targets) {
        int N = S.length();
        int[] match = new int[N];
        Arrays.fill(match, -1);

        for (int i = 0; i < indexes.length; ++i) {
            int ix = indexes[i];
            if (S.substring(ix, ix + sources[i].length()).equals(sources[i]))
                match[ix] = i;
        }

        StringBuilder ans = new StringBuilder();
        int ix = 0;
        while (ix < N) {
            if (match[ix] >= 0) {
                ans.append(targets[match[ix]]);
                ix += sources[match[ix]].length();
            } else {
                ans.append(S.charAt(ix++));
            }
        }
        return ans.toString();
    }

    public static String findReplaceString(String S,
                                           int[] indexes,
                                           String[] sources,
                                           String[] targets) {
        StringBuilder sb = new StringBuilder();
        LinkedHashSet<Integer> inSet = new LinkedHashSet<>();
        Arrays.stream(indexes).forEach(i -> inSet.add(i));

        if (isValid(indexes, sources, targets)) {
            int i = 0;
            int j = 0;
            while (i < S.length()) {
                if (inSet.contains(Integer.valueOf(i))) {
                    Iterator it = inSet.iterator();
                    int pos = 0;
                    while (it.hasNext()) {
                        int res = (int) it.next();
                        if (i == res) {
                            j = pos;
                            break;
                        }
                        pos++;
                    }
                    String str = sources[j];

                    if (S.substring(i, i + str.length()).contains(str)) {
                        sb.append(targets[j]);
                        i += str.length();
                        j++;
                    }
                    {
                        if (i < S.length()) {
                            sb.append(S.charAt(i));
                            i++;
                        }
                    }
                } else {
                    sb.append(S.charAt(i));
                    i++;
                }
            }


        }
        return sb.toString();

    }

    private static boolean isValid(int[] indexes, String[] sources, String[] targets) {
        if (indexes.length == sources.length) {
            if (sources.length == targets.length)
                return true;
        }
        return false;
    }
}
