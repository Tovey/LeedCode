package xtu.cie.ldj;

public class RemoveLinkedListElements {
	public ListNode removeElements(ListNode head, int val) {
		while (head != null && head.val == val) {
			head = head.next;
		}
		if (head == null || head.next == null)
			return head;
		ListNode preNode = head;
		ListNode tmpNode = preNode.next;
		while (tmpNode != null) {
			if (tmpNode.val == val) {
				preNode.next = tmpNode.next;
			} else {
				preNode = preNode.next;
			}

			tmpNode = preNode.next;
		}

		return head;
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
