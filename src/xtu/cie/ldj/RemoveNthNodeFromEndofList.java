package xtu.cie.ldj;

public class RemoveNthNodeFromEndofList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (n == 0 || head == null)
			return head;

		ListNode tmpNode = new ListNode(-1);
		tmpNode.next = head;
		head = tmpNode;
		tmpNode = tmpNode.next;

		int len = 0;
		while (tmpNode != null) {
			len++;
			tmpNode = tmpNode.next;
		}

		if (n == len) {
			return head.next.next;
		}

		n = n % len;

		tmpNode = head;
		for (int i = 0; i < len - n; i++) {
			tmpNode = tmpNode.next;
		}
		tmpNode.next = tmpNode.next.next;

		return head.next;
	}

	private static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
