package com.company.DataStructure;

/**
 * Created by jason on 16/6/8.
 */
public class ListNodeOperation {
    public ListNode createListNode(int[] nums)
    {
        if(nums.length == 0)
            return null;
        ListNode head = new ListNode(nums[0]);
        ListNode node = head;
        for(int i = 1; i < nums.length; i++)
        {
            node.next = new ListNode(nums[i]);
            node = node.next;
        }
        return head;
    }
    public void printListNode(ListNode node)
    {
        while(node != null)
        {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
