package dailycodings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LargestConSubArraySum {
    LargestConSubArraySum las;

    @BeforeEach
    public void init() {
        las = new LargestConSubArraySum();
    }

    @Test
    public void firstTest() {
        int[] input=new int[]{-2, -3, 4, -1, -2, 1, 5, -3};
        Assertions.assertEquals(7,las.maxSubArraySum(input));

    }

    public int maxSubArraySum(int[] in) {
        int max_so_far = 0;
        int max_end = 0;
        for (int i = 0; i < in.length; i++) {
            max_end = max_end + in[i];
            if (max_end < 0)
                max_end = 0;
            if (max_end > max_so_far)
                max_so_far = max_end;
        }
        return max_so_far;
    }
}
