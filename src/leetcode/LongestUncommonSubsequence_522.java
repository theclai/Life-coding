package leetcode;

import java.util.HashMap;

public class LongestUncommonSubsequence_522 {
    public static void main(String[] args) {

    }

    /**
     * 1. all the subsequence of all the words and count frequency
     * 2. subsequence whose frequency 1 is the target
     * 3. find the max lenght of frequency one
     * It takes extra space of hashmap
     */
    public int findLUSlength(String[] strs) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : strs) {
            for (int i = 0; i < (1 << s.length()); i++) {
                String t = "";
                for (int j = 0; j < s.length(); j++) {
                    if (((i >> j) & 1) != 0)
                        t += s.charAt(j);
                }
                if (map.containsKey(t))
                    map.put(t, map.get(t) + 1);
                else
                    map.put(t, 1);
            }
        }
        int res = -1;
        for (String s : map.keySet()) {
            if (map.get(s) == 1)
                res = Math.max(res, s.length());
        }
        return res;
    }

    /**
     *By some analysis, we can note that if longest uncommon subsequence is there, then it will always be one of the string
     * from the given list of strings. Using this idea, we can check each string that
     * whether it is a subsequence of any other string. If a string is not a subsequence of any other string i.e. it is uncommon ,
     *  we will return maximum length string out of them. If no string found, we will return .
     */
    public boolean isSubsequence(String x, String y) {
        int j = 0;
        for (int i = 0; i < y.length() && j < x.length(); i++)
            if (x.charAt(j) == y.charAt(i))
                j++;
        return j == x.length();
    }

    public int findLUSlength1(String[] strs) {
        int res = -1;
        for (int i = 0, j; i < strs.length; i++) {
            for (j = 0; j < strs.length; j++) {
                if (j == i)
                    continue;
                if (isSubsequence(strs[i], strs[j]))
                    break;
            }
            if (j == strs.length)
                res = Math.max(res, strs[i].length());
        }
        return res;
    }
}
