package com.company;

import com.company.DataStructure.TreeNode;

/**
 * Created by jason on 16/7/4.
 * Maximum depth of tree equal to maximum depth between left subtree and right subtree;
 * We can get depth of subtree recursively.
 */
public class MaximumDepthofBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(maxDepth(root.right), maxDepth(root.left));
    }
}
