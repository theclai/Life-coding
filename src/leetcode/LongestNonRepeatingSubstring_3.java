package leetcode;

import java.util.HashMap;

public class LongestNonRepeatingSubstring_3 {
    public static void main(String[] args) {
        //String in = "abcabcbb";
        //String in="bbbbb";
        //String in="pwwkew";
        String in="c";

        System.out.println(lengthOfLongestSubstring(in));

    }

    private static int lengthOfLongestSubstring(String in) {
        if(in.length()==0){
            return 0;
        }
        if(in.equalsIgnoreCase(" "))
            return 1;
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

            if(temp.length()>currentMax.length())
                currentMax=temp.toString();
            end++;
        }
        return currentMax.length();
    }
}
