package program_creek;

import java.util.LinkedHashMap;
import java.util.TreeMap;

public class LongestSustringWithKDistinctChars {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringTwoDistinct("abcbbbbcccbdddadacb"));
    }

    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) return 0;
        int k = 2;
        int maxLen = 0;
        int start=0;
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        TreeMap<Integer,Character> tMap=new TreeMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, i);
                tMap.put(i,c);
            } else {
                if (map.size() == k) {
                    char key = tMap.entrySet().iterator().next().getValue();
                    int pos = map.get(key);
                    tMap.remove(tMap.entrySet().iterator().next().getKey());
                    map.remove(key);
                    maxLen = Math.max(maxLen, i - start);
                    start=pos+1;
                    map.put(c,i);
                    tMap.put(i,c);
                } else {
                    map.put(c, i);
                    tMap.put(i,c);
                }
            }
            maxLen = Math.max(maxLen, i - start+1);
        }
        return maxLen;
    }
}
