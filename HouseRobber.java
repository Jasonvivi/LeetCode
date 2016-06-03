package com.company;

/**
 * Created by jason on 16/6/3.
 */
public class HouseRobber {
    public int rob(int[] nums)
    {
        if(nums.length < 1)
            return 0;
        if(nums.length < 2)
            return nums[0];
        int[] rob = new int[nums.length];
        rob[0] = nums[0];
        rob[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < rob.length; i++)
        {
            rob[i] =Math.max(rob[i -2] + nums[i],rob[i-1]);
        }
        return rob[rob.length - 1];
    }
}
