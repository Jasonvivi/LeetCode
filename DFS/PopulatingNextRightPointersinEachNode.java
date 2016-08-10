package com.company.DFS;

import com.company.DataStructure.TreeLinkNode;
import com.company.DataStructure.TreeNode;
import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by jason on 16/8/1.
 */
public class PopulatingNextRightPointersinEachNode {
//    public void connect(TreeLinkNode root) {
//        Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
//        if(root == null)
//            return;
//        queue.offer(root);
//        while(!queue.isEmpty())
//        {
//            int size = queue.size();
//            TreeLinkNode curNode;
//            for(int i = 0; i < size; i++)
//            {
//                curNode = queue.poll();
//                // use size to determine level end.
//                if(i < size - 1)
//                {
//                    curNode.next = queue.peek();
//                }
//                if(curNode.left != null)
//                    queue.offer(curNode.left);
//                if(curNode.right != null)
//                    queue.offer(curNode.right);
//            }
//        }
//    }
    public void connect(TreeLinkNode root)
    {
        if(root == null)
            return;
        while(root.left != null)
        {
            TreeLinkNode curNode = root;
            TreeLinkNode prevNode = null;
            while(curNode != null)
            {
                if(prevNode != null)
                    prevNode.next = curNode.left;
                curNode.left.next = curNode.right;
                prevNode = curNode.right;
                curNode = curNode.next;
            }
            root = root.left;
        }
    }
}
