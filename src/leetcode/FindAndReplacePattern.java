package leetcode;

import java.util.*;

/**
 * Problem statement can be found https://leetcode.com/contest/weekly-contest-98/problems/find-and-replace-pattern/
 */
public class FindAndReplacePattern {
    public static void main(String[] args) {
        String[] words = {"abc", "deq", "mee", "aqq", "dkd", "ccc"};
        String pattern = "abb";
        List list = findAndReplacePattern(words, pattern);
        System.out.println(list.size());
    }

    public static List<String> findAndReplacePattern(String[] words, String pattern) {
        HashMap<Character, Character> visits = new HashMap<>();
        HashMap<Character, Character> seen = new HashMap<>();
        List<String> strings = new ArrayList<>();

        for (String word : words) {
            boolean tag = true;
            for (int i = 0; i < pattern.length(); i++) {
                Character charP = pattern.charAt(i);
                Character charW = word.charAt(i);
                Character charVisits = visits.get(charP);
                Character charSeen = seen.get(charW);
                if (charVisits == null & charSeen == null) {
                    visits.put(charP, charW);
                    seen.put(charW, charP);
                } else if (charVisits != null && charSeen == null) {
                    tag = false;
                    break;

                } else if (charVisits != null) {
                    if (charSeen != charP) {
                        tag = false;
                    }
                } else {
                    tag = false;
                    break;
                }
            }
            if (tag)
                strings.add(word);
            visits.clear();
            seen.clear();
        }
        return strings;
    }
}
