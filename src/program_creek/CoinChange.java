package program_creek;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        int[] coins=new int[]{1,2,5};
        int n=11;
        System.out.println(findCoins(coins,n));
    }

    private static int findCoins(int[] coins, int n) {
        int[] cache= new int[n+1];
        Arrays.fill(cache,Integer.MAX_VALUE);
        for (int i = 1; i <=n; i++) {
            for (int j = 0; j <coins.length ; j++) {
                int coin=coins[j];
                if(coin==i) cache[i]=1;
                if(coin<i)
                    cache[i]=Math.min(cache[i],cache[i-coin]+1);
            }
        }
        return cache[n];
    }
}
