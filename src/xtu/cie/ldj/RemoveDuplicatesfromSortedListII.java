package xtu.cie.ldj;

public class RemoveDuplicatesfromSortedListII {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	// Accepted:343ms
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode T = null;
		ListNode tailT = T;
		while (head != null) {
			if (head.next != null && head.val == head.next.val) {
				while (head.next != null && head.val == head.next.val) {
					head = head.next;
				}
			} else {
				if (T == null) {
					T = head;
					tailT = T;
				} else {
					tailT.next = head;
					tailT = tailT.next;
				}
			}
			head = head.next;
		}
		if (tailT != null)
			tailT.next = null;
		return T;
	}
}
