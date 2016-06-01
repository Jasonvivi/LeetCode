package com.company;

import java.util.*;

/**
 * Created by jason on 16/5/31.
 */
public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> resList = new ArrayList<List<Integer>>();
        //helper1(resList, nums, 0, nums.length - 1);
        Arrays.sort(nums);
        helper(resList,new ArrayList<>(),nums, new boolean[nums.length]);
        return resList;
    }
    private void helper1(List<List<Integer>> resList, int[] nums, int start, int end)
    {
        if(start == end)
        {
            ArrayList<Integer> numSet = new ArrayList<Integer>();
            for(int i = 0; i < nums.length; i++)
            {
                numSet.add(nums[i]);
            }
            if(!resList.contains(numSet))
            {
                resList.add(new ArrayList<Integer>(numSet));
            }
        }
        else
        {
            Set<Integer> appeared = new HashSet<>();
            for(int i = start; i <= end; i ++)
            {
                if(appeared.add(nums[i]))
                {
                    int tmp = nums[start];
                    nums[start] = nums[i];
                    nums[i] = tmp;

                    helper1(resList, nums, start + 1, end);

                    tmp = nums[start];
                    nums[start] = nums[i];
                    nums[i] = tmp;
                }
            }
        }
    }
    private void helper(List<List<Integer>> resList, List<Integer> numSet,int[] nums,boolean[] used)
    {
        if (numSet.size() == nums.length)
        {
            resList.add(new ArrayList<Integer>(numSet));
        }
        else
        {
            for(int i = 0; i < nums.length; i++)
            {
                if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i - 1]) continue;
                used[i] = true;
                numSet.add(nums[i]);
                helper(resList, numSet, nums,used);
                used[i] = false;
                numSet.remove(numSet.size() - 1);

            }
        }
    }

    public static void main(String[] args) {
        // write your code here
        PermutationsII permutations = new PermutationsII();
        int[] nums = {1,1,2};
        System.out.println(permutations.permuteUnique(nums));
    }
}
