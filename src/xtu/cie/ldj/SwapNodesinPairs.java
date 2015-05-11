package xtu.cie.ldj;

public class SwapNodesinPairs {
	public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode tail = new ListNode(-1);
        tail.next = head;
        head = tail;
        ListNode node1,node2;
        while(tail.next != null && tail.next.next != null){
            node1 = tail.next;
            node2 = node1.next;
            
            tail.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            tail = node1;
        }
        
        return head.next;
    }
}
