package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {
    static String[] map = new String[10];

    public static void main(String[] args) {
        map = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        String num = "23";
        List<String> res = findCombinations(map, num);
        res.stream().forEach(o -> System.out.println(o));
    }

    private static List<String> findCombinations(String[] map,
                                                 String num) {
        ArrayList<String> result = new ArrayList<>();
        if (num.length() == 0)
            return result;
        result.add("");

        char[] c = num.toCharArray();
        for (int i = 0; i < c.length; i++) {
            String s = map[c[i] - '0'];
            ArrayList<String> tmp = new ArrayList<>();
            for (char letter : s.toCharArray()) {
                for (String str : result) {
                    tmp.add(str + letter);
                }
            }
            result = tmp;
        }
        Collections.sort(result);
        return result;
    }
}
