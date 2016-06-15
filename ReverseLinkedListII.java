package com.company;

import com.company.DataStructure.ListNode;
import com.company.DataStructure.ListNodeOperation;

import java.util.List;

/**
 * Created by jason on 16/6/10.
 */
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        int index = 0;
        if(m == n)
            return head;
        ListNode node = head;
        ListNode preNode= null;
        ListNode mPreNode = null;
        ListNode mNode = null;
        ListNode nNode = null;
        ListNode nNextNode = null;
        while(node != null)
        {
            index++;
            if(index < m)
            {
                mPreNode = node;
                node = node.next;
                continue;
            }
            if(index == m)
            {
                mNode = node;
                preNode = node;
                node = node.next;
                continue;
            }
            if(index > m && index < n)
            {
                ListNode tmpNode = node.next;
                node.next = preNode;
                preNode = node;
                node = tmpNode;
                continue;
            }
            if(index == n)
            {
                nNode = node;
                nNextNode = node.next;
                node.next = preNode;
                if(mPreNode == null)
                    head = nNode;
                else
                    mPreNode.next = nNode;
                mNode.next = nNextNode;
                break;
            }
        }
        return head;
    }
    public static void main(String[] args) {
        // write your code here
        ListNodeOperation listNodeOperation = new ListNodeOperation();
        ListNode head = listNodeOperation.createListNode(new int[]{3,5});
        ReverseLinkedListII swapNodesInPairs = new ReverseLinkedListII();
        listNodeOperation.printListNode(swapNodesInPairs.reverseBetween(head,1,1));
    }
}
