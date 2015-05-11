package xtu.cie.ldj;

public class RotateList {
	public ListNode rotateRight(ListNode head, int k) {
		if(head == null || head.next == null || k == 0)
            return head;
        int len = 0;
        ListNode tmpNode = head;
        while(tmpNode.next != null){
            len ++;
            tmpNode = tmpNode.next;
        }
        len ++;
        
        k = k % len;
        if(k == 0)
            return head;
        
        tmpNode.next = head; 
        tmpNode = head;
        for(int i = 1; i < len - k; i++){
            tmpNode = tmpNode.next;
        }
        head = tmpNode.next;
        tmpNode.next = null;
        
        return head;
	}

	private static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
