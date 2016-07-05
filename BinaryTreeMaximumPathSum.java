package com.company;

import com.company.DataStructure.TreeNode;
import com.sun.javafx.tools.ant.DeployFXTask;

/**
 * Created by jason on 16/7/5.
 */
public class BinaryTreeMaximumPathSum {
    public int maxVal;
    public int maxPathSum(TreeNode root) {
        maxVal = Integer.MIN_VALUE;
        findMax(root);
        return maxVal;
    }
    public int findMax(TreeNode root)
    {
        if(root == null)
            return 0;
        int left = findMax(root.left);
        int right = findMax(root.right);
        maxVal = Math.max((left + right + root.val), maxVal);
        int res=  Math.max(left,right) + root.val;
        return res < 0? 0: res;
    }
}
