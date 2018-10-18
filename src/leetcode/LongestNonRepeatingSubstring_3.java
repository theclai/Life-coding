package leetcode;

import java.util.HashMap;

public class LongestNonRepeatingSubstring_3 {
    public static void main(String[] args) {
        String in = "abcabcbb";
        //String in="bbbbb";
        //String in="pwwkew";

        System.out.println(findSubString(in));

    }

    private static int findSubString(String in) {
        int start = 0;
        int end = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        String currentMax="";
        StringBuilder temp = new StringBuilder();
        while (start <= end && end < in.length()) {
            char c = in.charAt(end);
            if (!map.containsKey(c)) {
                temp.append(c);
                map.put(c, end);
            } else {
                start = map.get(c)+1;
                if (currentMax.length() <= temp.length()) {
                    currentMax = temp.toString();
                    temp.setLength(0);
                }
                temp.append(in.charAt(start));
            }

            end++;
        }
        return currentMax.length();
    }
}
