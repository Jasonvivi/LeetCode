package com.company;

import com.company.DataStructure.ListNode;

/**
 * Created by jason on 16/6/10.
 */
public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode node = head;
        int length = 0;
        while(node != null)
        {
            length++;
            node = node.next;
        }
        for(int i = 1; i <= length; i++)
        {
            if(i % k == 0)
            {

            }
        }
    }
}
