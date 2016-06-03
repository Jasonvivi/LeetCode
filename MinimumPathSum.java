package com.company;

/**
 * Created by jason on 16/6/3.
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int[][] path = new int[grid.length][grid[0].length];
        path[0][0] = grid[0][0];
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                if(i == 0 && j > 0)
                {
                    path[i][j] = grid[i][j] + path[i][j - 1];
                }
                else if(j == 0 && i > 0)
                {
                    path[i][j] = grid[i][j] + path[i - 1][j];
                }
                else if(j > 0 && i > 0)
                {
                    path[i][j] = grid[i][j] + Math.min(path[i - 1][j],path[i][j - 1]);
                }
            }
        }
        return path[grid.length - 1][grid[0].length - 1];
    }
    public static void main(String[] args) {
        // write your code here
        int[][] grid = {{1,2,3},{1,2,3},{1,2,3}};
        MinimumPathSum minimumPathSum = new MinimumPathSum();
        System.out.println(minimumPathSum.minPathSum(grid));
    }
}
