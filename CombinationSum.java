package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jason on 16/5/26.
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> resList = new ArrayList<List<Integer>>();
        List<Integer> numSet = new ArrayList<Integer>();
        Arrays.sort(candidates);
        helper(resList, numSet, candidates,target,0);
        return resList;
    }
    private void helper(List<List<Integer>> resList, List<Integer> numSet, int[] candidates, int target,int index)
    {
        if(target < 0)
            return ;
        if(target == 0)
        {
            resList.add(new ArrayList<Integer>(numSet));
            return;
        }
        for(int i = index; i < candidates.length; i++)
        {
            numSet.add(candidates[i]);
            helper(resList,numSet,candidates,target - candidates[i],index);
            numSet.remove((numSet.size() -1));
            index++;
        }
    }
    public static void main(String[] args) {
        // write your code here
        int[] candidates = {2,3,5,7};
        int target = 7;
        CombinationSum combinationSum  = new CombinationSum();
        System.out.println(combinationSum.combinationSum(candidates,target));
    }
}
