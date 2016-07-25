package com.company.LinkedList;

import com.company.DataStructure.ListNode;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

/**
 * Created by jason on 16/7/20.
 */
public class AddTwoNumbers {
    /* ugly solution */
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummyNode = new ListNode(0);
        ListNode cur = dummyNode;
        ListNode node1 = l1;
        ListNode node2 = l2;
        int num = 0;
        while (node1 != null && node2 != null) {
            num = node1.val + node2.val + carry;
            if (num > 9) {
                num = num - 10;
                carry = 1;
            } else {
                carry = 0;
            }
            cur.next = new ListNode(num);
            cur = cur.next;
            node1 = node1.next;
            node2 = node2.next;
        }
        while (node1 != null) {
            num = node1.val + carry;
            if (num > 9) {
                num = num - 10;
                carry = 1;
            } else {
                carry = 0;
            }
            cur.next = new ListNode(num);
            cur = cur.next;
            node1 = node1.next;
        }
        while (node2 != null) {
            num = node2.val + carry;
            if (num > 9) {
                num = num - 10;
                carry = 1;
            } else {
                carry = 0;
            }
            cur.next = new ListNode(num);
            cur = cur.next;
            node2 = node2.next;
        }
        if (carry != 0) {
            cur.next = new ListNode(carry);
            carry = 0;
        }
        return dummyNode.next;
    }


    /* neat solution */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyhead = new ListNode(0);
        ListNode cur = dummyhead;
        ListNode node1 = l1;
        ListNode node2 = l2;
        int carry = 0;
        while(node1 != null || node2 != null)
        {
            int x = node1 == null ? 0 : node1.val;
            int y = node2 == null ? 0 : node2.val;
            int digit = x + y;
            carry = digit / 10;
            cur.next = new ListNode(digit % 10);
            cur = cur.next;
            if(node1 != null)
                node1 = node1.next;
            if(node2 != null)
                node2 = node2.next;
        }
        if(carry > 0)
            cur.next = new ListNode(carry);
        return  dummyhead.next;
    }

}