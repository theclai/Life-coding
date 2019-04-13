package dailycodings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MinCoinChange_138 {
    MinCoinChange_138 minCoinChange;
    int[] coins = new int[]{1, 5, 10, 25};

    @BeforeEach
    public void init() {
        minCoinChange = new MinCoinChange_138();
    }

    @Test
    public void testWhenTotalCoinEleven() {
        int T = 16;
        int total = findTotalCoint(T, coins);
        System.out.println(total);

    }

    private int findTotalCoint(int amount, int[] coins) {
        // this will store the optimal solution
        // for all the values -- from 0 to given amount.
        int[] coinReq = new int[amount + 1];

        coinReq[0] = 0; // 0 coins are required to make the change for 0
        // now solve for all the amounts
        for (int amt = 1; amt <= amount; amt++) {
            coinReq[amt] = Integer.MAX_VALUE;
            // Now try taking every coin one at a time and pick the minimum
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= amt) { // check if coin value is less than amount
                    // select the coin and add 1 to solution of (amount-coin value)
                    coinReq[amt] = Math.min(coinReq[amt - coins[j]] + 1, coinReq[amt]);
                }
            }
        }
        //return the optimal solution for amount
        return coinReq[amount];
    }
}
