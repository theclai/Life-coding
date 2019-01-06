package program_creek;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    LongestConsecutiveSequence lcs;
    @BeforeEach
    public void init() {
        lcs = new LongestConsecutiveSequence();
    }
    @Test
    public void test() {
        int[] input = new int[]{100, 4, 200, 1, 3, 2};
        System.out.println(lcs.findRange(input));
        Assertions.assertEquals(4,lcs.findRange(input));
    }

    public int findRange(int[] input) {
        Set<Integer> set = new HashSet<>();
        Arrays.stream(input).forEach(value -> set.add(value));

        int maxRange = 0;
        for (int i = 0; i < input.length; i++) {
            int max = input[i];
            while (set.contains(max + 1)) {
                max = max + 1;
            }
            System.out.println("Max: "+ max);
            int min = input[i];
            while (set.contains(min - 1)) {
                min = min - 1;
            }
            System.out.println("Min: "+min);
            maxRange = Math.max(maxRange, (max - min) + 1);
        }
        return maxRange;
    }
}
