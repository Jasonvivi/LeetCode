package com.company;

import com.company.DataStructure.ListNode;
import com.company.DataStructure.ListNodeOperation;

import java.util.List;

/**
 * Created by jason on 16/6/9.
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        ListNode node = head;
        int length = 0;
        while(node != null)
        {
            length++;
            node = node.next;
        }
        int midLength = length / 2;
        node = head;
        ListNode preNode = null;
        while(midLength != 0)
        {
            ListNode tmpNode = node.next;
            node.next =preNode;
            preNode = node;
            node = tmpNode;
            midLength --;
        }
        if(length % 2 == 1)
            node = node.next;
        while(node !=null && preNode != null)
        {
            if(node.val != preNode.val)
                return false;
            node = node.next;
            preNode = preNode.next;
        }
        return true;
    }
    public static void main(String[] args) {
        // write your code here
        ListNodeOperation listNodeOperation = new ListNodeOperation();
        ListNode head = listNodeOperation.createListNode(new int[]{});
        PalindromeLinkedList swapNodesInPairs = new PalindromeLinkedList();
        System.out.println(swapNodesInPairs.isPalindrome(head));
        //listNodeOperation.printListNode(swapNodesInPairs.isPalindrome(head));
    }

}
