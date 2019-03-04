package hackerrank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PermutationEquation {
    public static void main(String[] args) {
        int[] res = permutationEquation(new int[]{5, 2, 1, 3, 4});
        Arrays.stream(res).forEach(i-> System.out.println(i));

    }

    static int[] permutationEquation(int[] p) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < p.length; i++) {
            map.put(p[i], i + 1);
        }

        int[] result = new int[p.length];
        for (int i = 1; i <= p.length; i++) {
            result[i-1] = map.get(map.get(i));
        }

        return result;
    }
}
