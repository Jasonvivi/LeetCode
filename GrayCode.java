package com.company;

import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jason on 16/5/26.
 */
public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>();
        res.add(0);
        for(int i = 0; i < n; i++)
        {
            for(int j = res.size() - 1; j >= 0 ; j--)
            {
                int num = res.get(j) + (1 << i);
                res.add(num);
            }
        }
        return res;
    }

    public List<Integer> grayCode1(int n)
    {
        List<Integer> res = new ArrayList<Integer>();
        int index = 0;
        res.add(0);
        recursive(res,index,n);
        return res;
    }
    private void recursive(List<Integer> res,int index, int size)
    {
        if(index >= size)
            return;
        for(int i = res.size() -1 ; i >= 0; i--)
        {
            res.add(res.get(i) + (1 << index));
        }
        recursive(res,index+1,size);
    }
    public static void main(String[] args) {
        // write your code here
        GrayCode basicCalculatorII = new GrayCode();
        System.out.println(basicCalculatorII.grayCode1(2));
    }
}
