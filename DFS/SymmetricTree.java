package com.company.DFS;

import com.company.DataStructure.TreeNode;

/**
 * Created by jason on 16/8/2.
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        return helper(root.left, root.right);
    }
    public boolean helper(TreeNode left, TreeNode right)
    {
        if(left == null && right == null)
            return true;
        if(left == null || right == null)
            return false;
        if(left.val != right.val)
            return false;
        return helper(left.left, right.right) && helper(left.right, right.left);
    }
}
