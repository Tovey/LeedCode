package xtu.cie.ldj;

public class SameTree {
	/**
	 * Accepted:215ms
	 */
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null || q == null)
			return p == q;

		if (p.val == q.val) {
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		}
		
		return false;
	}

	private class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
