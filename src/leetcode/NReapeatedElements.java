package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class NReapeatedElements {
    NReapeatedElements nre;

    @BeforeEach
    public void init() {
        nre = new NReapeatedElements();
    }

    public int repeatedNTimes(int[] A) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            if (map.containsKey(A[i])) {
                map.put(A[i], map.get(A[i]) + 1);
                if (map.get(A[i]) == A.length / 2)
                    return A[i];
            } else {
                map.put(A[i], 1);
            }
        }
        return 0;
    }

    @Test
    public void testFirst() {
        int[] input = new int[]{1, 2, 3, 3};
        Assertions.assertEquals(nre.repeatedNTimes(input), 3);
    }

    @Test
    public void testSecond() {
        int[] input = new int[]{2, 1, 2, 5, 3, 2};
        Assertions.assertEquals(nre.repeatedNTimes(input), 2);
    }

    @Test
    public void testThird() {
        int[] input = new int[]{5, 1, 5, 2, 5, 3, 5, 4};
        Assertions.assertEquals(nre.repeatedNTimes(input), 5);
    }
}
