package xtu.cie.ldj;

public class ReverseLinkedListII {
	public ListNode reverseBetween_2(ListNode head, int m, int n) {
		if (m == n || head == null || head.next == null)
			return head;

		ListNode pre = new ListNode(-1);
		pre.next = head;
		head = pre;
		int i = 1;
		for (; i < m; i++) {
			pre = pre.next;
		}
		ListNode start = pre.next;
		ListNode then = start.next;
		for (; i < n; i++) {
			start.next = then.next;
			then.next = pre.next;
			pre.next = then;
			then = start.next;
		}

		return head.next;
	}

	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (m == n || head == null || head.next == null)
			return head;

		ListNode pre = new ListNode(-1);
		pre.next = head;
		head = pre;

		int i = 1;

		while (i < m) {
			pre = pre.next;
			i++;
		}

		ListNode startNode = pre.next;

		ListNode tmpNode1 = startNode;
		ListNode tmpNode2 = tmpNode1.next;
		ListNode tmpNode = tmpNode2.next;
		startNode.next = null;
		i++;
		while (i <= n) {
			tmpNode = tmpNode2.next;
			tmpNode2.next = tmpNode1;
			tmpNode1 = tmpNode2;
			tmpNode2 = tmpNode;
			i++;
		}

		startNode.next = tmpNode2;
		pre.next = tmpNode1;

		return head.next;
	}

	public void printListNode(ListNode head) {
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		ReverseLinkedListII reverseLinkedListII = new ReverseLinkedListII();
		int[] array = new int[] { 1, 2, 3 };
		ListNode head = new ListNode(array[0]);
		ListNode tmp = head;
		for (int i = 1; i < array.length; i++) {
			tmp.next = new ListNode(array[i]);
			tmp = tmp.next;
		}
//		reverseLinkedListII.reverseBetween_2(head, 1, 3);
		reverseLinkedListII.printListNode(reverseLinkedListII.reverseBetween_2(head, 1, 3));
	}

	private static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
