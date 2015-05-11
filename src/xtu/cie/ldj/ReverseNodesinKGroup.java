package xtu.cie.ldj;

public class ReverseNodesinKGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || k <= 1)
			return head;
		ListNode tail = new ListNode(-1);
		tail.next = head;
		head = tail;
		while (hasKNodesLeft(tail, k)) {
			int c = k - 1;
			ListNode start = tail.next;
			ListNode then = start.next;

			while (c-- > 0) {
				start.next = then.next;
				then.next = tail.next;
				tail.next = then;
				then = start.next;
			}

			tail = start;
		}

		return head.next;
	}

	private boolean hasKNodesLeft(ListNode tail, int k) {
		while (k-- > 0) {
			if (tail.next == null)
				return false;
			tail = tail.next;
		}

		return true;
	}
}
