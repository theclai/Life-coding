package hackerrank;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import static java.util.function.Function.*;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class SparseArray {
    static int[] matchingStrings(String[] strings, String[] queries) {
        if(strings==null || strings.length==0||queries==null||queries.length==0)return new int[0];
        List<String> list = Arrays.asList(strings);
        Map<String, Long> map = list.stream().collect(groupingBy(identity(), counting()));
        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            if (map.containsKey(queries[i]))
                result[i] = Math.toIntExact(map.get(queries[i]));
            else
                result[i] = 0;
        }
        return result;
    }
}
