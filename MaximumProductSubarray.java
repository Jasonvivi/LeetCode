package com.company;

/**
 * Created by jason on 16/6/4.
 */
public class MaximumProductSubarray {
    //
    public int maxProduct(int[] nums) {
        int [] dp = new int[nums.length];
        if(nums.length == 0)
            return 0;
        dp[0] = nums[0];
        for(int i = 1; i < nums.length; i++)
        {
            dp[i] = dp[i - 1];
        }
        int[] bignum = new int[Integer.MAX_VALUE];
        int[] bignum2 = new int[Integer.MAX_VALUE];
        stack(bignum,bignum2);
        return 0;
    }

    public void stack(int[] bignum,int[] bignum2)
    {

    }
    public static void main(String[] args) {
        // write your code here
        int[] nums = {2,3,-2,4};
        MaximumProductSubarray maximumProductSubarray  = new MaximumProductSubarray();
        System.out.println(maximumProductSubarray.maxProduct(nums));
    }
}
