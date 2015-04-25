package xtu.cie.ldj;

public class ValidateBinarySearchTree {
	public boolean isValidBST(TreeNode root) {
		if (root == null) {
			return true;
		}

		return isAllLess(root.left, root.val)
				&& isAllGreater(root.right, root.val) && isValidBST(root.left)
				&& isValidBST(root.right);
	}

	private boolean isAllLess(TreeNode root, int val) {
		if (root == null)
			return true;
		if (root.val >= val)
			return false;
		return isAllLess(root.left, val) && isAllLess(root.right, val);
	}

	private boolean isAllGreater(TreeNode root, int val) {
		if (root == null)
			return true;
		if (root.val <= val)
			return false;
		return isAllGreater(root.left, val) && isAllGreater(root.right, val);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(1);

		ValidateBinarySearchTree v = new ValidateBinarySearchTree();

		System.out.println(v.isValidBST(root));
	}

	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
