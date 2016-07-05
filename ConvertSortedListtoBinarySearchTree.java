package com.company;

import com.company.DataStructure.ListNode;
import com.company.DataStructure.TreeNode;

/**
 * Created by jason on 16/7/4.
 */
public class ConvertSortedListtoBinarySearchTree {
    ListNode node;
    public TreeNode sortedListToBST(ListNode head) {
        //return createBSTtop2down(head,null);
        int length = 0;
        node = head;
        while(node != null)
        {
            node = node.next;
            length++;
        }
        return createBSTbottom2up(0, length - 1);
    }
    /*
     * Solution1:
     *  top-down recursive solution is easy to understand. Apply the similar way from covert array to BST.
     *  Using two pointers slow and fast to determine mid.
     *  The time complexity is O(nlogn), space is O(n).
     */
    public TreeNode createBSTtop2down(ListNode low, ListNode high)
    {
        while(low == high)
            return null;
        ListNode slow = low;
        ListNode fast = low;
        while(fast != high && fast.next != high)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = createBSTtop2down(low, slow);
        root.right = createBSTtop2down(slow.next,high);
        return root;
    }
    /*
     * Solution2;
     * bottom-up is another way to solve this problem. Firstly we create left subtree
     *
     */
    public TreeNode createBSTbottom2up(int low, int high)
    {
        if(low > high)
            return null;
        int mid = (high - low) / 2 + low;
        TreeNode leftchild = createBSTbottom2up(low, mid -1);
        TreeNode parent = new TreeNode(node.val);
        parent.left = leftchild;
        node = node.next;
        parent.right = createBSTbottom2up(mid + 1, high);
        return parent;
    }
}
