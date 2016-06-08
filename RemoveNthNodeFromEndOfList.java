package com.company;

import com.company.DataStructure.ListNode;

/**
 * Created by jason on 16/6/8.
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode node = head;
        while(node != null)
        {
            length++;
            node = node.next;
        }
        int index = length - n;
        if(index == 0)
        {
            head = head.next;
            return head;
        }
        node = head;
        while(index > 1)
        {
            node = node.next;
            index --;
        }
        node.next = node.next.next;
        return head;
    }
}
