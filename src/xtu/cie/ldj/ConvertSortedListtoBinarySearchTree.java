package xtu.cie.ldj;

public class ConvertSortedListtoBinarySearchTree {
	public TreeNode sortedListToBST(ListNode head) {
		if(head == null)	return null;
		else if(head.next == null) return new TreeNode(head.val);
		
		ListNode fast = head.next.next;
		ListNode slow = head;
		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		TreeNode root = new TreeNode(slow.next.val);
		root.right = sortedListToBST(slow.next.next);
		slow.next = null;
		root.left = sortedListToBST(head);
		return root;
    }
	
	
	public TreeNode sortedListToBST02(ListNode head) {
		tmpList = head;
		return generate(countNodesNum(head));
    }
	
	private ListNode tmpList = null;
	
	private TreeNode generate(int n){
		if(n == 0)	return null;
		TreeNode node = new TreeNode(0);
		node.left = generate(n / 2);
		node.val = tmpList.val;
		tmpList = tmpList.next;
		node.right = generate(n - n / 2 - 1);
		return node;
	}
	
	private int countNodesNum(ListNode node){
		int count = 0;
		while(node != null){
			count ++;
			node = node.next;
		}
		
		return count;
	}
}
