package com.company.LinkedList;

import com.company.DataStructure.ListNode;

/**
 * Created by jason on 16/7/23.
 */
public class IntersectionofTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while(nodeA != null)
        {
            lenA++;
            nodeA = nodeA.next;
        }
        while(nodeB != null)
        {
            lenB++;
            nodeB = nodeB.next;
        }
        if(lenA > lenB)
        {
            for(int i = 0; i < lenA - lenB; i++)
            {
                headA = headA.next;
            }
        }
        else
        {
            for(int i = 0; i < lenB - lenA; i++)
            {
                headB = headB.next;
            }
        }
        while(headA != null && headB != null)
        {
            if(headA == headB)
                return headA;
        }
        return null;
    }
}
