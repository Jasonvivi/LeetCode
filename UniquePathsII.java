package com.company;

/**
 * Created by jason on 16/6/3.
 */
public class UniquePathsII {
    private int sum = 0;
    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        helper(obstacleGrid,0,0);
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
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] nums = new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int i = 0; i < obstacleGrid.length; i++)
        {
            if(obstacleGrid[i][0] != 1)
                nums[i][0] = 1;
            else
            {
                nums[i][0] = 0;
                break;
            }
        }
        for(int j = 0; j < obstacleGrid[0].length; j++)
        {
            if(obstacleGrid[0][j] != 1)
                nums[0][j] = 1;
            else
            {
                nums[0][j] = 0;
                break;
            }
        }
        for(int i = 1; i < obstacleGrid.length; i++)
            for(int j = 1; j < obstacleGrid[0].length; j++)
            {
                if(obstacleGrid[i][j] == 1)
                {
                    nums[i][j] = 0;
                    continue;
                }
                nums[i][j] = nums[i - 1][j] + nums[i][j - 1];
            }
        return nums[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }

    public static void main(String[] args) {
        // write your code here
        UniquePathsII uniquePaths = new UniquePathsII();
        System.out.println(uniquePaths.uniquePathsWithObstacles(new int[][]{{1,0}}));
    }
}
