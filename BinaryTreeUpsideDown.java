package com.company;

import com.company.DataStructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by jason on 16/7/6.
 */
public class BinaryTreeUpsideDown {
    /*
     * Solution1:
     * DFS, it is straightforward.
     */
    public TreeNode invertTreeDFS(TreeNode root) {
        if(root == null)
            return root;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTreeDFS(root.left);
        invertTreeDFS(root.right);
        return root;
    }
    /*
     * Solution2:
     * use stack data structure to replace of application stack.
     */
    public TreeNode invertTreeStack(TreeNode root)
    {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(root == null)
            return root;
        stack.push(root);
        while(!stack.isEmpty())
        {
            TreeNode node = stack.pop();
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
            if(node.left != null)
                stack.push(node.left);
            if(node.right != null)
                stack.push(node.right);
        }
        return root;
    }
    /*
     * Solution3:
     * BFS with queue.
     */
    public TreeNode invertTreeBFS(TreeNode root)
    {
        if(root == null)
            return root;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty())
        {
            TreeNode node = queue.poll();
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
            if(node.left != null)
                queue.offer(node.left);
            if(node.right != null)
                queue.offer(node.right);
        }
        return root;
    }
}
