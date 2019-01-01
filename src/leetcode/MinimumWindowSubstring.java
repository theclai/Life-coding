package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }

    private static String minWindow(String S, String T) {
        Map<Character, Long> dict = T.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.counting()));
        System.out.println(dict);

        HashMap<Character, Integer> found = new HashMap<>();
        int foundCounter = 0;
        int start = 0;
        int end = 0;
        int min = Integer.MAX_VALUE;
        String minWindow = "";

        while (end < S.length()) {
            char c = S.charAt(end);
            if (dict.containsKey(c)) {
                if (found.containsKey(c)) {
                    if (found.get(c) < dict.get(c))
                        foundCounter++;
                    found.put(c, found.get(c) + 1);
                } else {
                    found.put(c, 1);
                    foundCounter++;
                }
            }
            if (foundCounter == T.length()) {
                //When foundCounter equals to T.length(), in other words, found all characters.
                char sc = S.charAt(start);
                while (!found.containsKey(sc) || found.get(sc) > dict.get(sc)) {
                    if (found.containsKey(sc) && found.get(sc) > dict.get(sc))
                        found.put(sc, found.get(sc) - 1);
                    start++;
                    sc = S.charAt(start);
                }
                if (end - start + 1 < min) {
                    minWindow = S.substring(start, end + 1);
                    min = end - start + 1;
                }
            }
            end++;
        }
        return minWindow;
    }
}
