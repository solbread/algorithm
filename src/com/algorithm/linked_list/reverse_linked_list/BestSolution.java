package com.algorithm.linked_list.reverse_linked_list;

import com.algorithm.etc.ListNode;

public class BestSolution {
	public ListNode reverseList(ListNode head) {
		return reverse(head, null);		
	}
	private ListNode reverse(ListNode head, ListNode result) {
		if(head == null) return result;
		ListNode nextHead = head.next;
		head.next = result;
		return reverse(nextHead, head);
	}
	public static void main(String[] args) {
		BestSolution solution = new BestSolution();
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
