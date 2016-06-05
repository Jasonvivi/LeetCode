package com.company;

/**
 * Created by jason on 16/6/5.
 */
public class UglyNumberII {
    public int nthUglyNumber1(int n) {
        int[] dp = new int[n];
        if(n <= 1)
            return n;
        dp[0] = 1;
        for(int i = 1; i < n; i++)
        {
            int num1 = Integer.MAX_VALUE;
            int num2 = Integer.MAX_VALUE;
            int num3 = Integer.MAX_VALUE;
            for(int j = 0; j < i; j++)
            {
                if(num1 == Integer.MAX_VALUE && dp[j] * 2 > dp[i -1])
                    num1 = dp[j] * 2;
                if(num2 == Integer.MAX_VALUE && dp[j] * 3 > dp[i -1])
                    num2 = dp[j] * 3;
                if(num3 == Integer.MAX_VALUE && dp[j] * 5 > dp[i - 1])
                    num3 = dp[j] * 5;
            }
            dp[i] = Math.min(num1,Math.min(num2,num3));
        }
        return dp[n - 1];
    }
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        if(n <= 1)
            return n;
        dp[0] = 1;
        int index1 = 0;
        int index2 = 0;
        int index3 = 0;
        for(int i = 1; i < n; i++)
        {
            int num1 = Integer.MAX_VALUE;
            int num2 = Integer.MAX_VALUE;
            int num3 = Integer.MAX_VALUE;
            if(dp[index1] * 2 > dp[i -1])
                num1 = dp[index1] * 2;
            else
                index1++;
            if(dp[index2] * 3 > dp[i -1])
                num2 = dp[index2] * 3;
            else
                index2++;
            if(dp[index3] * 5 > dp[i - 1])
                num3 = dp[index3] * 5;
            else
                index3++;
            dp[i] = Math.min(num1,Math.min(num2,num3));
            if(dp[i] == num1)
                index1++;
            if(dp[i] == num2)
                index2++;
            if(dp[i] == num3)
                index3++;
        }
        return dp[n - 1];
    }
    public static void main(String[] args)
    {
        UglyNumberII uglyNumberII = new UglyNumberII();
        System.out.println(uglyNumberII.nthUglyNumber(10));
    }
}
