package com.algorithm.linked_list.reverse_linked_list;

import com.algorithm.etc.ListNode;

public class BestSolution2 {
	public ListNode reverseList(ListNode head) {
		ListNode result = null;
		while(head != null) {
			ListNode next = head.next;
			head.next = result;
			result = head;
			head = next;
		}
		return result;
	}
	public static void main(String[] args) {
		BestSolution2 solution = new BestSolution2();
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
