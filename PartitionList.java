package com.company;

import com.company.DataStructure.ListNode;
import com.company.DataStructure.ListNodeOperation;

/**
 * Created by jason on 16/6/9.
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode node = head;
        ListNode preNode = null;
        ListNode preBigNode = null;
        ListNode bigNode = null;
        while(node != null)
        {
            if(node.val > x)
            {
                bigNode = node;
                node = node.next;
            }
            if(bigNode != null)
            {
                if(node.val < x)
                {
                    preBigNode.next = node;
                    node.next = bigNode.next;
                    preNode.next = bigNode;
                    bigNode.next = node.next;
                    node = bigNode;
                    bigNode = null;
                }
            }
            else
            {
                preBigNode = node;
            }
            preNode = node;
            node = node.next;
        }
        return head;
    }
    public static void main(String[] args) {
        // write your code here
        ListNodeOperation listNodeOperation = new ListNodeOperation();
        ListNode head = listNodeOperation.createListNode(new int[]{1,4,3,2,5,2});
        PartitionList swapNodesInPairs = new PartitionList();
        listNodeOperation.printListNode(swapNodesInPairs.partition(head,3));
    }
}
