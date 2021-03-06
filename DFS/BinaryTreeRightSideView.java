package com.company.DFS;

import com.company.DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by jason on 16/8/1.
 */
public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(root == null)
            return res;
        queue.offer(root);
        while(!queue.isEmpty())
        {
            int size = queue.size();
            for(int i = 0; i < size; i++)
            {
                TreeNode cur = queue.poll();
                if(i == size - 1)
                {
                    res.add(cur.val);
                }
                if(cur.left != null)
                    queue.offer((cur.left));
                if(cur.right != null)
                    queue.offer(cur.right);
            }
        }
        return res;
    }
}
