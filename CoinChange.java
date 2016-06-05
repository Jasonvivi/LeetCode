package com.company;

/**
 * Created by jason on 16/6/5.
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        if (amount == 0)
            return 0;
        if (coins.length == 0)
            return -1;
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] <= amount)
                dp[coins[i]] = 1;
        }
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j] && dp[i - coins[j]] != Integer.MAX_VALUE) {
                    dp[i] = dp[i - coins[j]] + 1;
                    if (dp[i] < min) {
                        min = dp[i];
                    }
                }
            }
            dp[i] = min;
        }
        return dp[amount] == Integer.MAX_VALUE? -1 : dp[amount];
    }
    public static void main(String[] args) {
        // write your code here

        CoinChange coinChange  = new CoinChange();
        System.out.println(coinChange.coinChange(new int[]{2},11));
    }
}
