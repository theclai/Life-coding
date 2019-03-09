package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class LongestIncreasingSubsequence_03_2019 {
    LongestIncreasingSubsequence_03_2019 lis;

    @BeforeEach
    public void init() {
        lis = new LongestIncreasingSubsequence_03_2019();
    }

    @Test
    public void first_list_positive() {
        int[] mock = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        int res = findLis(mock);
        Assertions.assertEquals(4, res);
    }

    private int findLis(int[] mock) {
        if (mock == null || mock.length == 0) return 0;
        if (mock.length == 1) return 1;

        int[] result = new int[mock.length];
        Arrays.fill(result, 1);
        int max = 1;
        for (int i = 1; i < mock.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (mock[j] < mock[i]) {
                    result[i] = Math.max(result[j] + 1, result[i]);
                    max = Math.max(max, result[i]);
                }
            }
        }
        return max;
    }
}
