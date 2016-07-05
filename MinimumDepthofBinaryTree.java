package com.company;

import com.company.DataStructure.TreeNode;
import com.company.DataStructure.TreeOperation;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by jason on 16/7/4.
 */
public class MinimumDepthofBinaryTree {
    public int minDepth1(TreeNode root) {
        if(root == null)
            return 0;
        if(root.left == null)
            return minDepth1(root.right) + 1;
        if(root.right == null)
            return minDepth1(root.left) + 1;
        return Math.min(minDepth1(root.left), minDepth1(root.right)) + 1;
    }

    public int minDepth(TreeNode root)
    {
        if(root == null)
            return 0;
        int depth = 0;
        TreeNode rightmost = root;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(rightmost != null)
        {
            TreeNode node = queue.poll();
            if(node.left == null && node.right == null)
                break;
            if(node.left != null)
                queue.add(node.left);
            if(node.right != null)
                queue.add(node.right);
            if(node == rightmost)
            {
                depth++;
                rightmost = node.right != null ? node.right : node.left;
            }
        }
        return depth;
    }
    public static void main(String[] args) {
        // write your code here
        TreeOperation operation = new TreeOperation();
        operation.init(new int[]{2,0,1,3,0});
        TreeNode root = operation.createTree();
        MinimumDepthofBinaryTree solution = new MinimumDepthofBinaryTree();
        System.out.println(solution.minDepth(root));
    }
}
