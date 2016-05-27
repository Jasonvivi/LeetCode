package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jason on 16/5/26.
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> resList = new ArrayList<List<Integer>>();
        List<Integer> numSet = new ArrayList<Integer>();
        helper(resList,numSet,n,k,1);
        return resList;
    }
    private void helper(List<List<Integer>> resList,List<Integer> numSet, int n, int k,int index)
    {
        if(numSet.size() == k)
        {
            if(!resList.contains(numSet))
                resList.add(new ArrayList<Integer>(numSet));
        }
        for(int i = index; i <= n; i++)
        {
            numSet.add(i);
            index++;
            helper(resList,numSet,n,k, index);
            numSet.remove(numSet.size() - 1);
        }
    }
    public static void main(String[] args) {
        // write your code here
        Combinations combinations  = new Combinations();
        System.out.println(combinations.combine(4,1));
    }
}
