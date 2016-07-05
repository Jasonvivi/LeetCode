package com.company;

/**
 * Created by jason on 16/7/2.
 */
public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int row = 0;
        int col = n - 1;
        int i = 0;
        int j = 0;
        int toleft = 1;
        int toright = 0;
        int todown = 0;
        int toup = 0;
        int[][] res = new int[n][n];

        for(int num = 0; num < n * n; num++)
        {
            if(toright == 1)
            {
                res[row][i] = i;
                if(i == col)
                {
                    todown =1;
                    toright = 0;
                    row = row - i;
                }
            }
            else if(toleft == 1)
            {
                res[row][col - i] = i;
            }
            else if(toup == 1)
            {
                res[row - i][col] = i;
            }
            else if(todown == 1)
            {
                res[row + i][col] = i;
            }
        }
        return res;
    }
}
