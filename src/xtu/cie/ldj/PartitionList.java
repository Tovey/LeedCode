package xtu.cie.ldj;

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode smallHead = new ListNode(-1);
        ListNode smallTail = smallHead;
        ListNode bigHead = new ListNode(-1);
        ListNode bigTail = bigHead;
        while(head != null){
        	if(head.val < x){
        		smallTail.next = head;
        		smallTail = smallTail.next;
        	}else {
				bigTail.next = head;
				bigTail = bigTail.next;
			}
        	head = head.next;
        }
        bigTail.next = null;
        smallTail.next = bigHead.next;
        return smallHead.next;
    }
}
