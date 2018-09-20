package leetcode;

import java.util.Currency;

public class CoinChange_322 {
    public int coinChange(int[] coins, int amount) {
        int[] cache = new int[amount + 1];

        /**
         * We will computing 0 dollars to amount
         * */
        for (int i = 1; i <= amount; i++) {
            int min=Integer.MAX_VALUE;
            for (int c : coins) {
                if (i - c >= 0) {
                    int currCoins = cache[i-c] + 1;
                    if(currCoins<min){
                        min=currCoins;
                    }
                }
            }
            cache[i]=min;

        }

        return cache[amount];
    }

}
