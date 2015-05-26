package xtu.cie.ldj;

public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
		return isSymmetric(root, root);
	}

	private boolean isSymmetric(TreeNode l_root, TreeNode r_root) {
		if (l_root == null && r_root == null)
			return true;

		if (l_root != null && r_root != null && l_root.val == r_root.val) {
			return isSymmetric(l_root.left, r_root.right)
					&& isSymmetric(l_root.right, r_root.left);
		}
		return false;
	}
}
