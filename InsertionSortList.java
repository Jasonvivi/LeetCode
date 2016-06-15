package com.company;

import com.company.DataStructure.ListNode;
import com.company.DataStructure.ListNodeOperation;

import java.util.List;

/**
 * Created by jason on 16/6/10.
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if(head == null)
            return head;
        ListNode newHead = head;
        head = head.next;
        newHead.next = null;
        while(head != null)
        {
            ListNode node = head;
            head = head.next;
            ListNode curNode = newHead;
            ListNode preNode = null;
            boolean istail = true;
            while(curNode != null)
            {
                if(node.val < curNode.val)
                {
                    if(preNode == null)
                    {
                        newHead = node;
                        node.next = curNode;
                    }
                    else
                    {
                        preNode.next = node;
                        node.next = curNode;
                    }
                    istail  = false;
                    break;
                }
                preNode = curNode;
                curNode = curNode.next;
            }
            if(istail == true)
            {
                preNode.next = node;
                node.next = null;
            }
        }
        return newHead;
    }
    public static void main(String[] args) {
        // write your code here
        ListNodeOperation listNodeOperation = new ListNodeOperation();
        ListNode head = listNodeOperation.createListNode(new int[]{2,4,3,5,1});
        InsertionSortList swapNodesInPairs = new InsertionSortList();
        listNodeOperation.printListNode(swapNodesInPairs.insertionSortList(head));
    }
}
