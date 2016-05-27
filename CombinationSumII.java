package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jason on 16/5/26.
 */
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
            if(!resList.contains(numSet))
            resList.add(new ArrayList<Integer>(numSet));
            return;
        }
        for(int i = index; i < candidates.length; i++)
        {
            numSet.add(candidates[i]);
            index++;
            helper(resList,numSet,candidates,target - candidates[i],index);
            numSet.remove((numSet.size() -1));
        }
    }
    public static void main(String[] args) {
        // write your code here
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        CombinationSumII combinationSum  = new CombinationSumII();
        System.out.println(combinationSum.combinationSum2(candidates,target));
    }
}
