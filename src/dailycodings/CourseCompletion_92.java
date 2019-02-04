package dailycodings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class CourseCompletion_92 {
    Map<String, ArrayList<String>> map;
    Set<String> processed;

    @BeforeEach
    public void init() {
        map = new TreeMap<>();
        processed = new HashSet<>();
        map.put("CSC100", new ArrayList<>());
        map.put("CSC200", new ArrayList<>());
        map.put("CSC100", new ArrayList<>()).add("CSC300");
        map.computeIfAbsent("CSC300", val -> new ArrayList<>()).add("CSC100");
        map.computeIfAbsent("CSC300", val -> new ArrayList<>()).add("CSC200");
    }

    @Test
    public void test_Positive() {
        List<String> res = new ArrayList<>();

        map.forEach((k, v) -> {
            if (!processed.contains(k)) {
                helper(k, res);
            }
        });
        res.forEach(str -> System.out.println(str));
    }

    private void helper(String start, List<String> res) {
        if (map.get(start).size() != 0) {
            for (String str : map.get(start)) {
                if (!processed.contains(str)) {
                    helper(str, res);
                }
            }
            res.add(start);
            processed.add(start);

        } else {
            res.add(start);
            processed.add(start);
        }
    }
}