package com.company;

/**
 * Created by jason on 16/6/4.
 */
public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        if(n < 2)
            return n;
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++)
            for(int j = 0; j < i; j++)
            {
                dp[i] += dp[i - 1 - j] *dp[j];
            }
        return dp[n];
    }
    public static void main(String[] args)
    {
        UniqueBinarySearchTrees uniqueBinarySearchTrees = new UniqueBinarySearchTrees();
        System.out.println(uniqueBinarySearchTrees.numTrees(3));
    }
}
