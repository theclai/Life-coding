package dailycodings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StockPrice {
    StockPrice sp;

    public int maxProfit(int[] in) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < in.length; i++) {
            if (in[i] < min) {
                min = in[i];
            }
            if (in[i] - min > max)
                max = in[i] - min;
        }
        System.out.println(max);
        return max;
    }

    @BeforeEach
    public void init() {
        sp = new StockPrice();
    }

    @Test
    public void firstTest() {
        int[] input = new int[]{9, 11, 8, 5, 7, 10, 20};
        Assertions.assertEquals(15, sp.maxProfit(input));
    }

    @Test
    public void secondTest() {
        int[] input = new int[]{100, 180, 260, 310, 40, 535, 695};
        Assertions.assertEquals(655, sp.maxProfit(input));
    }

}
