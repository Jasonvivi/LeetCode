package com.company.DFS;

/**
 * Created by jason on 16/8/2.
 */
public class LongestIncreasingPathinaMatrix {
    public int longestIncreasingPath(int[][] matrix) {
        return helper(matrix, 0, 0, Integer.MIN_VALUE,0);
    }
    public int helper(int[][] matrix, int x, int y, int previous, int path)
    {
        if(x < 0 || y < 0 || x >= matrix.length || y >= matrix[0].length)
            return path;
        int cur = matrix[x][y];
        if(cur <= previous)
            return path;
        if(matrix[x][y] > previous)
        {
            path ++;
        }
        int path1 = helper(matrix,x + 1, y, cur, path);
        int path2 = helper(matrix,x, y + 1, cur, path);
        int path3 = helper(matrix, x - 1, y, cur, path);
        int path4 = helper(matrix, x, y - 1, cur, path);
        return Math.max(Math.max(path1, path2), Math.max(path3, path4));
    }
}
