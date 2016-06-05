package com.company;

/**
 * Created by jason on 16/6/4.
 */
public class IntegerBreak {
    public int integerBreak(int n) {
        if(n <= 0)
            return 0;
        if(n == 2)
            return 1;
        if(n == 3)
            return 2;
        int product = 1;
        while(n > 4)
        {
            product *= 3;
            n = n -3;
        }
        if(n % 3 == 0)
            product *= 3;
        else if(n % 4 == 0)
            product *= 4;
        else if(n % 2 == 0)
            product *= 2;
        return product;
    }
    public static void main(String[] args) {
        // write your code here
        IntegerBreak integerBreak = new IntegerBreak();
        System.out.println(integerBreak.integerBreak(10));

    }
}
