package xtu.cie.ldj;

public class ReorderList {
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public void reorderList(ListNode head) {
		if (head == null || head.next == null) {
			return;
		}
		
		// count the node number
		int size = 1;
		ListNode tempNode = head;
		while(tempNode.next != null){
			tempNode = tempNode.next;
			size ++;
		}
		
		int count = size / 2;
		if (size % 2 == 0) {
			count --;
		}
		
		ListNode head2 = head;
		for (int i = 0; i <= count; i++) {
			tempNode = head2;
			head2 = head2.next;
		}
		tempNode.next = null;
		
		head2 = reverse(head2);
		
		ListNode tempNode1 = head;
		ListNode tempNode2 = tempNode1.next;
		
		while(head2 != null){
			tempNode1.next = head2;
			head2 = head2.next;
			tempNode1 = tempNode1.next;
			tempNode1.next = tempNode2;
			tempNode1 = tempNode1.next;
			if (tempNode1 != null) {
				tempNode2 = tempNode1.next;
			}
		}
	}
	
	public ListNode reverse(ListNode head){
		if (head == null || head.next == null) {
			return head;
		}
		
		ListNode preNode = head;
		ListNode currentNode = head.next;
		head = head.next.next;
		preNode.next = null;
		currentNode.next = preNode;
		
		while(head != null){
			preNode = currentNode;
			currentNode = head;
			head = head.next;
			currentNode.next = preNode;
		}
		
		return currentNode;
	}
	
	public void print(ListNode head,String str) {
		System.out.print(str + ": ");
		ListNode temp = head;
		while(temp != null){
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	public void test(){
		ListNode head = new ListNode(1);
		ListNode tail = head;
		for (int i = 2; i <= 5; i++) {
			ListNode temp = new ListNode(i);
			tail.next = temp;
			tail = tail.next;
		}
		print(head, "input data");
		reorderList(head);
		
		print(head, "head");
	}
}
