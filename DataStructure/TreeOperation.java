package com.company.DataStructure;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by jason on 16/7/4.
 */
public class TreeOperation {
    public TreeNode root;
    public int[] array;
    public int index = 0;

    public void init(int[] array)
    {
        this.array = array;
    }
    public TreeNode createTree()
    {
        root = new TreeNode(array[index++]);
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(index < array.length)
        {
            TreeNode node = queue.poll();
            if(array[index]!=0)
            {
                node.left = new TreeNode(array[index++]);
                queue.add(node.left);
            }
            else
            {
                index++;
            }
            if(index == array.length)
                break;
            if(array[index] !=0 )
            {
                node.right = new TreeNode(array[index++]);
                queue.add(node.right);
            }
            else
            {
                index++;
            }
        }
        return root;
    }
    public void preOrder(TreeNode root)
    {
        if(root == null)
            return;
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
}
