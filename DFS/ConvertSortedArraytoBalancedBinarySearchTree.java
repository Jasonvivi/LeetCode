package com.company.DFS;

import com.company.DataStructure.TreeNode;

/**
 * Created by jason on 16/7/4.
 */
public class ConvertSortedArraytoBalancedBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return createBST(nums, 0, nums.length - 1);
    }
    public TreeNode createBST(int[] nums, int low, int high)
    {
        if(low > high)
            return null;
        int mid = (high - low) / 2 + low;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = createBST(nums, low, mid - 1);
        root.right = createBST(nums, mid + 1, high);
        return root;
    }
}
