package com.algorithm.linked_list.reverse_linked_list;

import com.algorithm.etc.ListNode;

public class Solution {
	ListNode result;
	public ListNode reverseList(ListNode head) {
		if(head==null) return null;
		reverse(head);
		return result;
	}
	private ListNode reverse(ListNode head) {
		if(head.next == null) {
			result = new ListNode(head.val);
			return result;
		}
		ListNode tmp = reverse(head.next);
		tmp.next = new ListNode(head.val);
		return tmp.next;
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		ListNode head = new ListNode(2);
		head.next = new ListNode(3);
		head.next.next = new ListNode(1);
		ListNode reversedNode = solution.reverseList(head);
		while(reversedNode!=null) {
			System.out.println(reversedNode.val);
			reversedNode = reversedNode.next;
		}
	}
}

