package xtu.cie.ldj;

public class RecoverBinarySearchTree {
	TreeNode first = null;
	TreeNode second = null;
	TreeNode pre = new TreeNode(Integer.MIN_VALUE);

	public void recoverTree(TreeNode root) {
		traverse(root);
		int tmp = first.val;
		first.val = second.val;
		second.val = tmp;
	}

	private void traverse(TreeNode root) {
		if (root == null)
			return;
		traverse(root.left);
		if (first == null && pre.val >= root.val)
			first = pre;
		if (first != null && pre.val >= root.val)
			second = root;
		pre = root;
		traverse(root.right);
	}

	// Morris Traversal
	public void recoverTree_Morris(TreeNode root) {
		TreeNode firstNode = null, secondNode = null;
		TreeNode curNode = root, preNode = null;
		while (curNode != null) {
			if (curNode.left == null) {
				if (preNode != null && preNode.val >= curNode.val) {
					if (firstNode == null) {
						firstNode = preNode;
					}
					secondNode = curNode;
				}
				preNode = curNode;
				curNode = curNode.right;
			} else {
				TreeNode tmpNode = curNode.left;
				while (tmpNode.right != null && tmpNode.right != curNode) {
					tmpNode = tmpNode.right;
				}

				if (tmpNode.right == null) {
					tmpNode.right = curNode;
					curNode = curNode.left;
				} else {
					if (preNode != null && preNode.val >= curNode.val) {
						if (firstNode == null) {
							firstNode = preNode;
						}
						secondNode = curNode;
					}

					tmpNode.right = null;
					preNode = curNode;
					curNode = curNode.right;
				}
			}
		}
		int tmp = firstNode.val;
		firstNode.val = secondNode.val;
		secondNode.val = tmp;
	}
}
