package com.company;

import com.company.DataStructure.ListNode;
import com.company.DataStructure.ListNodeOperation;

/**
 * Created by jason on 16/6/8.
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode newHead = head.next;
        ListNode nextNode = head.next;
        ListNode curNode = head;

        curNode.next = nextNode.next;
        nextNode.next = curNode;
        while(curNode.next != null)
        {
            ListNode preNode = curNode;
            curNode = curNode.next;
            nextNode = curNode.next;
            if(nextNode == null)
                break;
            else
            {
                preNode.next = nextNode;
                curNode.next = nextNode.next;
                nextNode.next = curNode;
            }
        }
        return newHead;
    }
    public static void main(String[] args) {
        // write your code here
        ListNodeOperation listNodeOperation = new ListNodeOperation();
        ListNode head = listNodeOperation.createListNode(new int[]{1,2,3});
        SwapNodesInPairs swapNodesInPairs = new SwapNodesInPairs();
        listNodeOperation.printListNode(swapNodesInPairs.swapPairs(head));
    }
}
