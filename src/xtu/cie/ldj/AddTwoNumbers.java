package xtu.cie.ldj;

public class AddTwoNumbers {

	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		ListNode newList = null;
		
        ListNode tmp1 = l1;
        ListNode tmp2 = l2;
        
        while(tmp1!=null && tmp2!=null){
        	int val = tmp1.val + tmp2.val;
        	tmp1.val = val;
        	tmp2.val = val;
        	tmp1 = tmp1.next;
        	tmp2 = tmp2.next;
        }
        newList = l1;
        if(tmp1 != null) newList = l1;
        if(tmp2 != null) newList = l2;
        
        ListNode tmp = newList;
        boolean flag = false;
        while(tmp != null){
        	if(flag){
        		tmp.val += 1;
        	}
        	flag = false;
        	if(tmp.val >= 10){
        		tmp.val -= 10;
        		flag = true;
        		// the lastest
        		if(tmp.next == null){
        			ListNode t = new ListNode(1);
        			tmp.next = t;
        			tmp = tmp.next;
        		}
        	}
        	tmp = tmp.next;
        }
        
		return newList;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = new int[]{2,4,3};
		int[] arr2 = new int[]{5,6,4};
		
//		int[] arr1 = new int[]{2,4};
//		int[] arr2 = new int[]{5,6,4};
		
		ListNode l1 = null,l1_tmp = null;
		ListNode l2 = null,l2_tmp = null;
		
		for (int i = 0; i < arr1.length; i++) {
			ListNode tmp = new ListNode(arr1[i]);
			if (i == 0)	{ l1 = tmp;	l1_tmp = l1;}
			l1_tmp.next = tmp;
			l1_tmp = l1_tmp.next;
		}
		
		for (int i = 0; i < arr2.length; i++) {
			ListNode tmp = new ListNode(arr2[i]);
			if (i == 0)	{ l2 = tmp;	l2_tmp = l2;}
			l2_tmp.next = tmp;
			l2_tmp = l2_tmp.next;
		}
		
		printList(l1,"l1");
		printList(l2,"l2");
		
		l1 = addTwoNumbers(l1, l2);
		printList(l1,"l1");
		
	}
	
	public static void printList(ListNode head,String listName) {
		System.out.print(listName + ": ");
		ListNode tmp = head;
		while(tmp.next != null){
			System.out.print(tmp.val + " -> ");
			tmp = tmp.next;
		}
		System.out.println(tmp.val);
	}

}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
		next = null;
	}
}
