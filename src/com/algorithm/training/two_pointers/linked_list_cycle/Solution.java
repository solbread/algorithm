package com.algorithm.training.two_pointers.linked_list_cycle;

import com.algorithm.training.etc.ListNode;

public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null) return false;
        ListNode slowNode = head;
        ListNode fastNode = head;
        while(slowNode.next != null && fastNode.next != null && fastNode.next.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
            if(slowNode == fastNode) return true;
        }
        return false;
    }
    public static void main(String[] args) {
		Solution solution = new Solution();
		ListNode head = new ListNode(3);
		ListNode child1 = new ListNode(2);
		ListNode child2 = new ListNode(5);
		ListNode child3 = new ListNode(1);
		head.next = child1;
		child1.next = child2;
		child2.next = child3;
		child3.next = child2;
		System.out.println(solution.hasCycle(head));
	}
}
