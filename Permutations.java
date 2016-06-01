package com.company;

import java.lang.reflect.Array;
import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jason on 16/5/27.
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
 //       perm1(result,nums,0,nums.length-1);
        perm(result, new ArrayList<Integer>(),nums);
        return result;
    }
    public static void perm1(List<List<Integer>> result, int[] nums, int start, int end){
        if(start == end)
        {
            ArrayList<Integer> numSet = new ArrayList<Integer>();
            for(int i = 0; i < nums.length; i++)
            {
                numSet.add(nums[i]);
            }
            result.add(numSet);
        }
        else
        {
            for(int i = start; i <= end; i++)
            {
                int tmp = nums[start];
                nums[start] = nums[i];
                nums[i] = tmp;

                perm1(result,nums,start+1,end);

                tmp = nums[start];
                nums[start] = nums[i];
                nums[i] = tmp;
            }
        }
    }
    //solution2 using backtrack general solution.
    public static void perm(List<List<Integer>> result, List<Integer> numSet, int[] nums)
    {
        if(numSet.size() == nums.length)
        {
            result.add(new ArrayList<Integer>(numSet));
        }
        else
        {
            for(int i = 0; i < nums.length; i++)
            {
                if(numSet.contains(nums[i]))
                    continue;
                numSet.add(nums[i]);
                perm(result, numSet, nums);
                numSet.remove(numSet.size() - 1);
            }
        }
    }
    public static void main(String[] args) {
        // write your code here
        Permutations permutations = new Permutations();
        int[] nums = {1,2,3};
        System.out.println(permutations.permute(nums));
    }
}
