package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jason on 16/5/27.
 */
public class Subsets {
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
                numSet.add(nums[i]);
                helper(resList, numSet,nums, i + 1);
                numSet.remove(numSet.size() - 1);
            }
    }
    public static void main(String[] args) {
        // write your code here
        Subsets subsets = new Subsets();
        int[] nums = {1,2,3};
        System.out.println(subsets.subsets(nums));
    }
}
