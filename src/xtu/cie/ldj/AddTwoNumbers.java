package xtu.cie.ldj;

public class AddTwoNumbers {
	
	public static ListNode addTwoNumbers04(ListNode l1, ListNode l2) {
		ListNode list = new ListNode(0);
		ListNode tmpNode = list;
		int add = 0;
		while(l1 != null || l2 != null){
			if(l1 != null){
				tmpNode.next = l1;
				l1 = l1.next;
				tmpNode.next.next = null;
			}
			if(l2 != null){
				if(tmpNode.next == null){
					tmpNode.next = l2;
					l2 = l2.next;
					tmpNode.next.next = null;
				}else{
					tmpNode.next.val += l2.val;
					l2 = l2.next;
				}
			}
			tmpNode.next.val += add;
			add = 0;
			if(tmpNode.next.val >= 10){
				tmpNode.next.val -= 10;
				add = 1;
			}
			tmpNode = tmpNode.next;
		}
		if(add == 1){
			tmpNode.next = new ListNode(1);
		}
		
		return list.next;
	}
	
	
	/**
	 * 先求得链表的和，然后判断哪个链表是空，用非空的来进行操作
	 * 最后检查是否进位
	 * Accepted: 744ms
	 */
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
	
	/**
	 * 单独修改l1，当有一个链表为null时，再进行处理
	 * Accepted: 456ms
	 */
	public static ListNode addTwoNumbers02(ListNode l1, ListNode l2) {
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		ListNode newList = l1;
		ListNode tmpNode = newList;
		
		int add = 0;
		while(l1 != null && l2 != null){
			l1.val += l2.val + add;
			if (l1.val >= 10) {
				l1.val -= 10;
				add = 1;
			}else {
				add = 0;
			}
			
			tmpNode = l1;
			
			l1 = l1.next;
			l2 = l2.next;
		}
		
		if(l1 == null){
			tmpNode.next = l2;
		}
		
		while (tmpNode.next != null) {
			tmpNode = tmpNode.next;
			
			tmpNode.val += add;
			if (tmpNode.val >= 10) {
				tmpNode.val -= 10;
				add = 1;
			}else {
				add = 0;
			}
		}
		
		if (add == 1) {
			tmpNode.next = new ListNode(1);
		}
		
		return newList;
	}
	
	/**
	 * Accepted：492ms
	 */
	public static ListNode addTwoNumbers03(ListNode l1, ListNode l2) {
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		boolean addFlag = false;
		ListNode newList = new ListNode(-1);
		ListNode tmpNode = newList;
		
		while(l1 != null || l2 != null || addFlag){
			if (l1 != null) {
				tmpNode.next = l1;
				l1 = l1.next;
				tmpNode.next.next = null;
			}
			
			if (l2 != null) {
				if (tmpNode.next != null) {
					tmpNode.next.val += l2.val;
				}else {
					tmpNode.next = l2;
				}
				l2 = l2.next;
				tmpNode.next.next = null;
			}
			
			if (addFlag) {
				if(tmpNode.next != null){
					tmpNode.next.val += 1;
				}else {
					tmpNode.next = new ListNode(1);
				}
				addFlag = false;
			}
			
			if (tmpNode.next != null) {
				if(tmpNode.next.val >= 10){
					tmpNode.next.val -= 10;
					addFlag = true;
				}
				tmpNode = tmpNode.next;
			}
		}
		
		return newList.next;
	}
	
	public static void main(String[] args) {
//		int[] arr1 = new int[]{2,4,3};
//		int[] arr2 = new int[]{5,6,4};
		int[] arr1 = new int[]{0};
		int[] arr2 = new int[]{2,7,8};
		
		ListNode l1 = null,l1_tmp = null;
		ListNode l2 = null,l2_tmp = null;
		
		for (int i = 0; i < arr1.length; i++) {
			ListNode tmp = new ListNode(arr1[i]);
			if (i == 0)	{ l1 = tmp;	l1_tmp = l1; continue;}
			l1_tmp.next = tmp;
			l1_tmp = l1_tmp.next;
		}
		
		for (int i = 0; i < arr2.length; i++) {
			ListNode tmp = new ListNode(arr2[i]);
			if (i == 0)	{ l2 = tmp;	l2_tmp = l2; continue;}
			l2_tmp.next = tmp;
			l2_tmp = l2_tmp.next;
		}
		
		printList(l1,"l1");
		printList(l2,"l2");
		
		l1 = addTwoNumbers03(l1, l2);
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
	
	private static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
}

