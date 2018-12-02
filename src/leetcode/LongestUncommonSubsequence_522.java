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
}
