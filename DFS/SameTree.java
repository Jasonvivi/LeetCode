package com.company.DFS;

import com.company.DataStructure.TreeNode;

/**
 * Created by jason on 16/8/1.
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)
            return true;
        if((p != null && q == null) || (p == null && q != null))
            return false;
        if(p.val != q.val)
            return false;
        return isSameTree(p.left,q.left) && isSameTree(p.right, q.right);
    }
}
