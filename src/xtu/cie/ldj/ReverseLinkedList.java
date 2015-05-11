package xtu.cie.ldj;

public class ReverseLinkedList {
	// use recursive
	public ListNode reverseList_1(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode headRe = head;
        head = head.next;
        headRe.next = null;
        
        return reverseListRecur(head,headRe);
    }
    
    private ListNode reverseListRecur(ListNode head,ListNode headRe){
        if(head == null)
            return headRe;
            
        ListNode next = head.next;
        head.next = headRe;
        headRe = head;
        head = next;
        return reverseListRecur(head,headRe);
    }
    
    // use iterativel
    public ListNode reverseList_2(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode pre = head;
        head = head.next;
        pre.next = null;
        ListNode next = null;
        
        while(head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        
        head = pre;
        return head;
    }
    
    private class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}
}
