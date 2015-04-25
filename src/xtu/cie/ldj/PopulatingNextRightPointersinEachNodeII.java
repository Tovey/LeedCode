package xtu.cie.ldj;

public class PopulatingNextRightPointersinEachNodeII {
	/**
	 * Accepted:290ms
	 */
	public void connect_2(TreeLinkNode root){
		TreeLinkNode curNode = root;
		TreeLinkNode preNode = null;
		TreeLinkNode head = null;
		while(curNode != null){
			preNode = null;
			head = null;
			while(curNode != null){
				if(curNode.left != null){
					if (preNode != null) {
						preNode.next = curNode.left;
					}else {
						head = curNode.left;
					}
					preNode = curNode.left;
				}
				if (curNode.right != null) {
					if (preNode != null) {
						preNode.next = curNode.right;
					}else{
						head = curNode.right;
					}
					preNode = curNode.right;
				}
				
				curNode = curNode.next;
			}
			curNode = head;
		}
	}
	
	/**
	 * Accepted:295ms
	 */
	public void connect_1(TreeLinkNode root){
		if(root == null) return;
		TreeLinkNode head = root;
		TreeLinkNode tmpNode = null;
		TreeLinkNode nextHead = findNextFirstNode(head);
		
		while(nextHead != null){
			tmpNode = head;
			while(tmpNode != null){
				TreeLinkNode n_t = findNextNode(tmpNode);
				
				if(tmpNode.left != null){
					if(tmpNode.right != null){
						tmpNode.left.next = tmpNode.right;
						tmpNode.right.next = n_t;
					}else{
						tmpNode.left.next = n_t;
					}
				}else{
					if(tmpNode.right != null){
						tmpNode.right.next = n_t;
					}
				}
				
				tmpNode = tmpNode.next;
			}
			
			head = nextHead;
			nextHead = findNextFirstNode(head);
		}
	}
	
	private TreeLinkNode findNextFirstNode(TreeLinkNode node){
		while(node != null){
			if(node.left != null)
				return node.left;
			if(node.right != null)
				return node.right;
			node = node.next;
		}
		
		return null;
	}
	
	private TreeLinkNode findNextNode(TreeLinkNode t){
		if(t == null)
			return null;
		TreeLinkNode next = t.next;
		while(next != null){
			if(next.left != null)
				return next.left;
			if(next.right != null)
				return next.right;
			next = next.next;
		}
		return null;
	}
	
	private class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}
	}
}
