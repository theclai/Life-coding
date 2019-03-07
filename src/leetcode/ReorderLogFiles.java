package leetcode;

import java.util.*;

public class ReorderLogFiles {
    public static void main(String[] args) {
        String[] input = new String[]{"a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo"};
        reorderLogFiles(input);
    }

    public static String[] reorderLogFiles(String[] logs) {
        if (logs == null || logs.length == 0) return new String[]{};
        TreeMap<String, String> map = new TreeMap<>();
        List<String> numbers = new ArrayList<>();

        for (int i = 0; i < logs.length; i++) {
            String str = logs[i];
            String[] split = str.split(" ");
            if (Character.isLetter(split[1].charAt(0))) {
                map.put(str.substring(split[0].length() + 1, str.length()), str);
            } else {
                numbers.add(str);
            }
        }
        String[] result = new String[logs.length];
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        int i = 0;
        while (it.hasNext()) {
            Map.Entry<String, String> e = it.next();
            result[i] = e.getValue();
            i++;
        }

        for (int j = 0; j < numbers.size(); j++) {
            result[i + j] = numbers.get(j);
        }
        return result;

    }
}
