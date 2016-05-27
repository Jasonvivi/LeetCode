package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jason on 16/5/26.
 */
public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int target) {
        List<List<Integer>> resList = new ArrayList<List<Integer>>();
        List<Integer> numSet = new ArrayList<Integer>();
        int[] candidates = {1,2,3,4,5,6,7,8,9};
        helper(resList, numSet, candidates,target,0,0,k);
        return resList;
    }
    private void helper(List<List<Integer>> resList, List<Integer> numSet, int[] candidates, int target,int index, int path,int k)
    {
        if(target < 0)
            return ;
        if(target == 0 && path == k)
        {
            if(!resList.contains(numSet))
                resList.add(new ArrayList<Integer>(numSet));
            return;
        }
        if(path >=k)
            return ;
        for(int i = index; i < candidates.length; i++)
        {
            numSet.add(candidates[i]);
            helper(resList,numSet,candidates,target - candidates[i],i + 1,path + 1,k);
            numSet.remove((numSet.size() -1));
        }
    }
    public static void main(String[] args) {
        // write your code here
        int target = 9;
        CombinationSumIII combinationSum  = new CombinationSumIII();
        System.out.println(combinationSum.combinationSum3(1,target));
    }
}
