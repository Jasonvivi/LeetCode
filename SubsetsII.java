package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jason on 16/6/1.
 */
public class SubsetsII {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> resList = new ArrayList<List<Integer>>();
        List<Integer> numSet = new ArrayList<Integer>();
        helper(resList, numSet, nums, 0);
        return resList;
    }
    private void helper(List<List<Integer>> resList, List<Integer> numSet, int[] nums, int start)
    {
        resList.add(new ArrayList<Integer>(numSet));
        for(int i = start; i < nums.length; i++)
        {
            if(i > start && nums[i] == nums[i - 1])
                continue;
                numSet.add(nums[i]);
                helper(resList, numSet, nums, i + 1);
                numSet.remove(numSet.size() - 1);
        }
    }
    public static void main(String[] args) {
        // write your code here
        SubsetsII subsets = new SubsetsII();
        int[] nums = {1,2,2};
        System.out.println(subsets.subsets(nums));
    }
}
