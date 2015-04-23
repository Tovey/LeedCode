package xtu.cie.ldj;

public class RemoveDuplicatesfromSortedList {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
	// Accepted:297ms
	public ListNode deleteDuplicates(ListNode head) {
		if(head == null || head.next == null) return head;
		ListNode preNode = head;
		ListNode node = preNode.next;
		while(node != null){
			if(node.val == preNode.val){
				preNode.next = node.next;
			}else{
				preNode = node;
			}
			node = preNode.next;
		}
		return head;
	}

}
