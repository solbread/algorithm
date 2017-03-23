package com.algorithm.reverse_linked_list;

import com.algorithm.etc.ListNode;

public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null) return null;
		return reverse(head);
	}
	private ListNode reverse(ListNode head) {
		if(head.next == null) {
			return new ListNode(head.val);
		}
		ListNode tmp = reverse(head.next);
		tmp.next = new ListNode(head.val);
		return tmp;
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		ListNode head = new ListNode(2);
		head.next = new ListNode(3);
		head.next.next = new ListNode(1);
		ListNode reversedNode = solution.reverse(head);
		while(reversedNode!=null) {
			System.out.println(reversedNode.val);
			reversedNode = reversedNode.next;
		}
	}
}

