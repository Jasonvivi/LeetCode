package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jason on 16/6/4.
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size() == 0 || triangle.get(0).size() == 0)
            return 0;
        int[] dp = new int[triangle.size()];
        for(int i = 0; i < triangle.size(); i ++)
            dp[i] = Integer.MAX_VALUE;
        dp[0] = triangle.get(0).get(0);
        for(int i = 1; i < triangle.size(); i ++)
            for(int j = triangle.get(0).size() - 1; j >= 0; j--)
            {
                if(j > 0)
                    dp[j] = Math.min(dp[j - 1],dp[j]) + triangle.get(i).get(j);
                else
                    dp[j] = dp[j] + triangle.get(i).get(j);
            }
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < dp.length; i++)
        {
            if(dp[i] < min)
                min = dp[i];
        }
        return min;
    }

    public static void main(String[] args) {
        // write your code here

    }
}
