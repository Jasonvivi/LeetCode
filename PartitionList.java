package com.company;

import com.company.DataStructure.ListNode;
import com.company.DataStructure.ListNodeOperation;

import java.util.List;

/**
 * Created by jason on 16/6/9.
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode(0);
        ListNode right = new ListNode(0);
        ListNode leftCur = left;
        ListNode rightCur = right;
        while(head != null)
        {
            if(head.val < x)
            {
                leftCur.next = head;
                leftCur = head;
            }
            else
            {
                rightCur.next = head;
                rightCur = head;
            }
            head = head.next;
        }
        leftCur.next = right.next;
        rightCur.next = null;
        return left.next;
    }
    public static void main(String[] args) {
        // write your code here
        ListNodeOperation listNodeOperation = new ListNodeOperation();
        ListNode head = listNodeOperation.createListNode(new int[]{1,4,3,5,2});
        PartitionList swapNodesInPairs = new PartitionList();
        listNodeOperation.printListNode(swapNodesInPairs.partition(head,3));
    }
}
