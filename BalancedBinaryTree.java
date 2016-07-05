package com.company;

import com.company.DataStructure.TreeNode;

/**
 * Created by jason on 16/7/4.
 */
public class BalancedBinaryTree {
/*
 * Solution 1:
 * it is straightforward solution, which checks depth of every node's left and right subtree if the difference is less than abs(1).
 * However, it check every node repeatedly. The runtime is O(n^2).
 */
//    public boolean isBalanced(TreeNode root)
//    {
//        if(root == null)
//            return true;
//        return (Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1)
//                && isBalanced(root.left)
//                && isBalanced(root.right);
//
//    }
//    int maxDepth(TreeNode node)
//    {
//        if(node == null)
//            return 0;
//        return Math.max(maxDepth(node.left), maxDepth(node.right)) + 1;
//    }

    public boolean isBalanced(TreeNode root)
    {
        return maxDepth(root) == -1;
    }
    int maxDepth(TreeNode root)
    {
        if(root == null)
            return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        if(leftDepth == -1 || rightDepth == -1)
            return -1;
        if(Math.abs(leftDepth - rightDepth) > 1)
            return -1;
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
