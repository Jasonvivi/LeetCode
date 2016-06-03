package com.company;

/**
 * Created by jason on 16/6/3.
 */
public class HouseRobberII {
    public int rob(int[] nums) {
        if(nums.length < 1)
            return 0;
        if(nums.length < 2)
            return nums[0];
        int[] rob = new int[nums.length];
        rob[0] = 0;
        rob[1] = nums[1];
        for(int i = 2; i < rob.length; i++)
        {
            rob[i] =Math.max(rob[i -2] + nums[i],rob[i-1]);
        }
        int robWithoutFirst = rob[rob.length - 1];
        rob[0] = nums[0];
        rob[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < rob.length - 1; i++)
        {
            rob[i] =Math.max(rob[i -2] + nums[i],rob[i-1]);
        }
        int robWithFirst = rob[rob.length -2];
        return Math.max(robWithFirst,robWithoutFirst);
    }
}
