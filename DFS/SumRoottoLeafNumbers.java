package com.company.DFS;

import com.company.DataStructure.TreeNode;

/**
 * Created by jason on 16/8/2.
 */
public class SumRoottoLeafNumbers {
    public int sumNumbers(TreeNode root) {
        if(root == null)
            return 0;
        return helper(root, 0);
    }
    public int helper(TreeNode root, int sum)
    {
        int leftSum = 0;
        int rightSum = 0;
        if(root.left == null && root.right == null)
            return sum + root.val;
        if(root.left != null)
            leftSum = helper(root.left,(sum + root.val) * 10);
        if(root.right != null)
            rightSum = helper(root.right, (sum + root.val) * 10);
        return leftSum + rightSum;
    }
}
