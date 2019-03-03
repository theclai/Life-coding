package leetcode.contests.contest_126;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

public class FindCommonCharacters {
    FindCommonCharacters fcc;

    @BeforeEach
    public void init() {
        fcc = new FindCommonCharacters();
    }

    @Test
    public void first_test_positive() {
        String[] in = new String[]{"bella", "label", "roller"};
        Assertions.assertEquals(3, commonChars(in).size());
    }

    @Test
    public void second_test_positive() {
        String[] in = new String[]{"acabcddd", "bcbdbcbd", "baddbadb", "cbdddcac", "aacbcccd", "ccccddda", "cababaab", "addcaccd"};
        Assertions.assertEquals(0, commonChars(in).size());
    }

    public List<String> commonChars(String[] A) {
        if (A == null || A.length == 0) return new ArrayList<>();
        /**
         * This map will hold the expected output upto current location of the array
         * */
        HashMap<String, Integer> set = new HashMap<>();
        /**
         * Character counter for the word in current position
         * */
        HashMap<String, Integer> temp;

        /**
         * Output of similar characs between temp{@link temp} and {@link set}
         * */
        HashMap<String, Integer> resMap;
        for (int i = 0; i < A.length; i++) {
            String str = A[i];
            temp = new HashMap<>();
            resMap = new HashMap<>();
            if (i == 0 && set.isEmpty()) {
                updateTempMap(temp, str);
                set.putAll(temp);
                resMap.putAll(temp);
            } else {
                updateTempMap(temp, str);
            }

            Iterator<Map.Entry<String, Integer>> it = temp.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry e = it.next();
                if (set.containsKey(e.getKey())) {
                    int min = Math.min(set.get(e.getKey()), (Integer) e.getValue());
                    resMap.put(String.valueOf(e.getKey()), min);
                }
            }
            set.clear();
            /**
             * Update {@link set} with the result upto current position
             * */
            set.putAll(resMap);
            resMap.clear();
            temp.clear();
        }
        /**
         * Iterate over the map
         * add characters to list based on how many time has been  found in all the words
         * */
        List<String> result = new ArrayList<>();
        Iterator<Map.Entry<String, Integer>> it = set.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry e = it.next();
            int num = (int) e.getValue();
            for (int i = 0; i < num; i++) {
                result.add(String.valueOf(e.getKey()));
            }
        }
        return result;
    }

    private void updateTempMap(HashMap<String, Integer> temp, String str) {
        for (int j = 0; j < str.length(); j++) {
            if (temp.containsKey(String.valueOf(str.charAt(j)))) {
                temp.put(String.valueOf(str.charAt(j)), temp.get(String.valueOf(str.charAt(j))) + 1);
            } else {
                temp.put(String.valueOf(str.charAt(j)), 1);
            }
        }
    }
}
