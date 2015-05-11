package xtu.cie.ldj;

public class CopyListwithRandomPointer {
	/**
	 * 想到这算法的人真是天才
	 */
	public RandomListNode copyRandomList_2(RandomListNode head) {
		RandomListNode cur = head;
		while (cur != null) {
			RandomListNode tmpNode = new RandomListNode(cur.label);
			tmpNode.next = cur.next;
			cur.next = tmpNode;
			cur = tmpNode.next;
		}
		cur = head;
		while (cur != null) {
			if (cur.random != null) {
				cur.next.random = cur.random.next;
			}
			cur = cur.next.next;
		}
		RandomListNode newHead = new RandomListNode(-1);
		RandomListNode newCur = newHead;
		cur = head;
		while (cur != null) {
			newCur.next = cur.next;
			newCur = newCur.next;
			cur.next = cur.next.next;
			cur = cur.next;
		}
		newCur.next = null;
		return newHead.next;
	}

	public RandomListNode copyRandomList(RandomListNode head) {
		RandomListNode tmpNode = head;

		RandomListNode newHead = new RandomListNode(-1);
		RandomListNode newTail = newHead;
		while (tmpNode != null) {
			newTail.next = new RandomListNode(tmpNode.label);
			tmpNode = tmpNode.next;
			newTail = newTail.next;
		}
		tmpNode = head;
		RandomListNode tmpNewNode = newHead.next;
		while (tmpNode != null) {
			if (tmpNode.random == null) {
				tmpNewNode.random = null;
			} else {
				newTail = newHead.next;
				while (newTail.label != tmpNode.random.label) {
					newTail = newTail.next;
				}
				tmpNewNode.random = newTail;
			}
			tmpNode = tmpNode.next;
			tmpNewNode = tmpNewNode.next;
		}

		return newHead.next;
	}

	private class RandomListNode {
		int label;
		RandomListNode next, random;

		RandomListNode(int x) {
			this.label = x;
		}
	};
}
