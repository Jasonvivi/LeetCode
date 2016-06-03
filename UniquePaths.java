package com.company;

/**
 * Created by jason on 16/6/3.
 */
public class UniquePaths {
    private int sum = 0;
    public int uniquePaths1(int m, int n) {
        int[][] nums = new int[m][n];
        helper(nums,0,0);
        return sum;
    }
    public void helper(int[][] nums, int x, int y)
    {
        if(x == nums.length - 1 && y == nums[0].length - 1)
        {
            sum++;
        }
        if(x < 0 || y < 0 || x >= nums.length || y >= nums[0].length || nums[x][y] == 1)
            return;
        nums[x][y] = 1;
        helper(nums, x + 1, y);
        helper(nums, x, y + 1);
        nums[x][y] = 0;
    }

    public int uniquePaths(int m, int n)
    {
       int[][] nums = new int[m][n];
        for(int i = 0; i < m; i++)
            nums[i][0] = 1;
        for(int j = 0; j < n; j++)
            nums[0][j] = 1;
        for(int i = 1; i < m; i ++)
            for(int j = 1; j < n; j++)
            {
                nums[i][j] = nums[i-1][j] + nums[i][j - 1];
            }
        return nums[m - 1][n -1];
    }
    public static void main(String[] args) {
        // write your code here
        UniquePaths uniquePaths = new UniquePaths();
        System.out.println(uniquePaths.uniquePaths(1,2));
    }
}
