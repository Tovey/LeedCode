package xtu.cie.ldj;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersinEachNode {
	/**
	 * ∑«µ›πÈ
	 * Accepted:244ms
	 */
	public void connect_3(TreeLinkNode root){
		if(root == null) return;
		TreeLinkNode f = root;
		TreeLinkNode t = null;
		while(f.left != null){
			t = f;
			while(t != null){
				t.left.next = t.right;
				if(t.next != null){
					t.right.next = t.next.left;
				}
				t = t.next;
			}
			f = f.left;
		}
	}
	
	/** 
	 * µ›πÈ
	 * Accepted:259ms
	 */
	public void connect_2(TreeLinkNode root) {
		if (root == null)
			return;
		TreeLinkNode l = root.left;
		TreeLinkNode r = root.right;

		while (l != null && r != null) {
			l.next = r;
			l = l.right;
			r = r.left;
		}

		connect_2(root.left);
		connect_2(root.right);
	}

	/**
	 * ∂”¡–
	 *  Accepted: 308ms
	 */
	public void connect_1(TreeLinkNode root) {
		if (root == null)
			return;

		Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
		queue.add(root);

		while (!queue.isEmpty()) {
			int length = queue.size();
			TreeLinkNode tmpNode1 = null;
			TreeLinkNode tmpNode2 = null;

			for (int i = 0; i < length; i++) {
				if (queue.peek().left != null)
					queue.offer(queue.peek().left);
				if (queue.peek().right != null)
					queue.offer(queue.peek().right);
				if (tmpNode1 == null) {
					tmpNode1 = queue.poll();
				} else {
					tmpNode2 = queue.poll();
					tmpNode1.next = tmpNode2;
					tmpNode1 = tmpNode2;
				}
			}
		}
	}

	private class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}
	}
}
