package com.company;

import com.company.DataStructure.ListNode;
import com.company.DataStructure.ListNodeOperation;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

/**
 * Created by jason on 16/6/27.
 */
public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode node = head;
        int length = 0;
        while(node != null) {
            length++;
            node = node.next;
        }
        if(k > length || k == 1)
            return head;
        else
        {
            int index = 1;
            int kIndex = k;
            ListNode preNode = head;
            ListNode curNode = head.next;
            ListNode firstNode = head;
            ListNode preFirstNode = null;
            while(kIndex <= length)
            {
                while(index < kIndex)
                {
                    ListNode tmpNode = curNode.next;
                    curNode.next = preNode;
                    preNode = curNode;
                    curNode = tmpNode;
                    index ++;
                }
                firstNode.next = curNode;
                if(preFirstNode != null)
                    preFirstNode.next = preNode;
                else
                    head = preNode;
                if(curNode == null)
                    break;
                index = kIndex + 1;
                kIndex +=k;
                preFirstNode = firstNode;
                firstNode = curNode;
                preNode = curNode;
                curNode = curNode.next;
            }
        }
        return head;
    }
    public static void main(String[] args) {
        // write your code here
        ListNodeOperation listNodeOperation = new ListNodeOperation();
        ListNode head = listNodeOperation.createListNode(new int[]{1,2,3,4,5,6});
        ReverseNodesInKGroup swapNodesInPairs = new ReverseNodesInKGroup();
        listNodeOperation.printListNode(swapNodesInPairs.reverseKGroup(head,2));
    }
}
