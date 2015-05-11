package xtu.cie.ldj;

import java.util.HashMap;

public class LinkedListCycle2 {
	public ListNode detectCycle_2(ListNode head) {
		if (head == null || head.next == head)
			return head;
		ListNode fast = head,slow = head;
		
		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast){
				slow = head;
				while(slow != fast){
					slow = slow.next;
					fast = fast.next;
				}
				return slow;
			}
		}
		
		return null;
	}

	public static ListNode detectCycle(ListNode head) {
		if (head == null || head.next == head)
			return head;

		HashMap<ListNode, Integer> hashMap = new HashMap<ListNode, Integer>();

		ListNode tmpNode = head;
		boolean isExist = false;

		int i = 0;
		while (tmpNode != null) {
			if (hashMap.containsKey(tmpNode)) {
				isExist = true;
				break;
			} else {
				hashMap.put(tmpNode, i++);
			}
			tmpNode = tmpNode.next;
			if (isExist)
				break;
		}

		if (!isExist) {
			tmpNode = null;
		}

		return tmpNode;
	}

	public static boolean hasCycle(ListNode head) {
		if (head == null)
			return false;
		if (head.next == head)
			return true;

		HashMap<ListNode, Integer> hashMap = new HashMap<ListNode, Integer>();

		ListNode tmpNode = head;
		boolean isExist = false;

		int i = 0;
		while (tmpNode != null) {
			if (hashMap.containsKey(tmpNode)) {
				isExist = true;
				break;
			} else {
				hashMap.put(tmpNode, i++);
			}
			tmpNode = tmpNode.next;
			if (isExist)
				break;
		}

		return isExist;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode tmp = head;

		for (int i = 1; i < 10; i++) {
			tmp.next = new ListNode(i);
			tmp = tmp.next;
		}

		tmp.next = tmp;

		System.out.println(detectCycle(head).val);
	}

	private static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
}
