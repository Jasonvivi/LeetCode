package com.company;

/**
 * Created by jason on 16/6/3.
 */
public class PerfectSquares {
    public int numSquares1(int n) {
        int[] nums = new int[n + 1];
        for(int i = 0; i <= n; i++)
        {
            nums[i] = Integer.MAX_VALUE;
        }
        nums[0] = 0;
        nums[1] = 1;
        for(int i = 2; i <= n; i ++)
        {
            if(i * i <= n)
                nums[i * i] = 1;
            int min = Integer.MAX_VALUE;
            if(nums[i] != Integer.MAX_VALUE)
                continue;
            for(int j = 1; j < i; j++)
            {
                if(nums[i - j] + nums[j] < min)
                {
                    min = nums[i - j] + nums[j];
                }
            }
            nums[i] = min;
        }
        return nums[n];
    }

    public int numSquares(int n)
    {
        int[] nums = new int[n + 1];
        for(int i = 0; i < n + 1; i++)
            nums[i] = Integer.MAX_VALUE;
        nums[0] = 0;
        for(int i = 1; i < n + 1; i++)
        {
            int sqrt = (int)Math.sqrt(i);
            nums[sqrt * sqrt] = 1;
            if(i == sqrt * sqrt)
                continue;
            for(int j = 1; j <= sqrt; j++)
            {
                if(nums[i - j*j] + 1 < nums[i])
                    nums[i] = nums[i - j*j] + 1;
            }
        }
        return nums[n];
    }
    public static void main(String[] args) {
        // write your code here
        int[][] grid = {{1,2,3},{1,2,3},{1,2,3}};
        PerfectSquares perfectSquares = new PerfectSquares();
        System.out.println(perfectSquares.numSquares(5));
    }
}
