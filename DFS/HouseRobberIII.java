package com.company.DFS;

import com.company.DataStructure.TreeNode;

/**
 * Created by jason on 16/8/1.
 */
public class HouseRobberIII {
    public int rob(TreeNode root) {
        if(root == null)
            return 0;
        int[] maxSum = helper(root);
        return Math.max(maxSum[0], maxSum[1]);
    }
//    public int helper(TreeNode node, int sum)
//    {
//        if(node == null)
//            return sum;
//        int leftVal = node.left == null ? 0 : node.left.val;
//        int rightVal = node.right == null ? 0 : node.right.val;
//        // From top to bottom solution is wrong.
//        // It seems like a greedy solution, but it doesn't make sense.
//        if(leftVal + rightVal > node.val)
//        {
//            sum = sum - node.val + rightVal + leftVal;
//        }
//        else
//            sum += node.val;
//        helper(node.left, sum);
//        helper(node.right, sum);
//        return sum;
//    }
    public int[] helper(TreeNode node)
    {
        int[] maxSum = {0, 0};
        if(node == null)
            return maxSum;
        int[] leftSum = helper(node.left);
        int[] rightSum = helper(node.right);
        maxSum[0] = Math.max(leftSum[0], leftSum[1]) + Math.max(rightSum[0], rightSum[1]);
        maxSum[1] = leftSum[0] + rightSum[0] + node.val;
        return maxSum;
    }
}
