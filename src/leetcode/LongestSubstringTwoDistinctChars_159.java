package leetcode;

import java.util.*;

public class LongestSubstringTwoDistinctChars_159 {
    public static void main(String[] args) {
        String in = "abcabcabc";
        System.out.println(lengthOfLongestSubstringTwoDistinct(in));
    }

    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) return 0;
        if (s.length() == 1) return 1;
        Map<Character, Integer> map = new LinkedHashMap<>();

        Set<Character> set = new HashSet<>();
        int start = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, i);
            if (set.contains(c)) {
                set.add(c);
                max = Math.max(max, i - start + 1);
            } else {
                if (set.size() == 2) {

                    Iterator it = map.entrySet().iterator();
                    Map.Entry e1 = null;
                    Map.Entry e2 = null;
                    int counter = 0;
                    while (it.hasNext() && counter < 2) {
                        if (counter == 0)
                            e1 = (Map.Entry) it.next();
                        if (counter == 1)
                            e2 = (Map.Entry) it.next();
                        counter++;
                    }
                    if (map.get(e2.getKey()) < map.get(e1.getKey())) {
                        start = map.get(e2.getKey()) + 1;
                        set.remove(e2.getKey());
                        map.remove(e2.getKey());
                    } else {
                        start = map.get(e1.getKey()) + 1;
                        set.remove(e1.getKey());
                        map.remove(e1.getKey());
                    }
                    set.add(c);

                } else {
                    set.add(c);
                    max = Math.max(max, i - start + 1);
                }

            }
        }

        return max;
    }
}
