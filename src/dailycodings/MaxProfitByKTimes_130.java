package dailycodings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MaxProfitByKTimes_130 {
    MaxProfitByKTimes_130 mMaxProfit;

    @BeforeEach
    public void init() {
        mMaxProfit = new MaxProfitByKTimes_130();
    }

    @Test
    public void first_maxprofit_test() {
        int result = mMaxProfit.maxProfit(new int[]{10, 22, 5, 75, 65, 80}, 6, 2);
        Assertions.assertEquals(result, 87);
    }
    @Test
    public void second_maxprofit(){
        int result=mMaxProfit.maxProfit(new int[]{12, 14, 17, 10, 14, 13, 12, 15},8,2);
        Assertions.assertEquals(result, 12);
    }

    public int maxProfit(int[] price,
                         int n,
                         int k) {
        int total = 0;
        int min = 0;
        int max = 1;
        int temp=0;
        while (min < max && max < n && k > 0) {
            if (price[max] < price[min]) {
                total += price[max - 1] - price[min];
                min = max;
                max++;
                k--;
                temp=0;
            } else {
                max++;
                if(max==n)
                    total += price[max - 1] - price[min];
            }
        }
        return total;
    }
}
