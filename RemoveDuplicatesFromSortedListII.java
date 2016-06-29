package com.company;

import com.company.DataStructure.ListNode;
import com.company.DataStructure.ListNodeOperation;

/**
 * Created by jason on 16/6/29.
 */
public class RemoveDuplicatesFromSortedListII
{
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode preNode = null;
        ListNode curNode = head;
        ListNode nextNode = head.next;
        while (curNode != null && nextNode != null) {
            if (curNode.val != nextNode.val) {
                if (preNode == null) {
                    head = curNode;
                    preNode = curNode;
                    curNode = nextNode;
                    nextNode = nextNode.next;
                } else {
                    preNode.next = curNode;
                    preNode = curNode;
                    curNode = nextNode;
                    nextNode = nextNode.next;
                }
            } else {
                int tmpVal = curNode.val;
                while (curNode != null && curNode.val == tmpVal) {
                    curNode = curNode.next;
                }
                if(curNode != null)
                {
                    nextNode = curNode.next;
                }
            }
        }
        if(curNode != null && nextNode == null)
        {
            if(preNode == null) {
                head = curNode;
                preNode = curNode;
            }
            else
            {
                preNode.next = curNode;
                preNode = curNode;
            }
        }
        if(preNode == null)
            head = null;
        else
            preNode.next = null;
        return head;
    }
    public static void main(String[] args) {
        // write your code here
        ListNodeOperation listNodeOperation = new ListNodeOperation();
        ListNode head = listNodeOperation.createListNode(new int[]{1,2});
        RemoveDuplicatesFromSortedListII swapNodesInPairs = new RemoveDuplicatesFromSortedListII();
        listNodeOperation.printListNode(swapNodesInPairs.deleteDuplicates(head));
    }
}
