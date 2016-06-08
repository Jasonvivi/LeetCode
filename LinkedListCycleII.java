package com.company;

import com.company.DataStructure.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jason on 16/6/8.
 */
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        Map<ListNode,Integer> map = new HashMap<ListNode,Integer>();
        ListNode node = head;
        while(node != null)
        {
            if(map.containsKey(node))
                return node;
            map.put(node,0);
            node = node.next;
        }
        return null;
    }
}
