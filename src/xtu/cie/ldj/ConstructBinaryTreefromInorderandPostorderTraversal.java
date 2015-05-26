package xtu.cie.ldj;

public class ConstructBinaryTreefromInorderandPostorderTraversal {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		return buildTreeHelper(inorder, postorder, postorder.length - 1, 0,
				inorder.length - 1);
	}

	private TreeNode buildTreeHelper(int[] inorder, int[] postorder,
			int postIndex, int inStart, int inEnd) {
		if (postIndex < 0 || inStart > inEnd) {
			return null;
		}

		TreeNode root = new TreeNode(postorder[postIndex]);
		int index = inStart;
		for (int i = index; i <= inEnd; i++) {
			if (inorder[i] == root.val) {
				index = i;
				break;
			}
		}

		root.right = buildTreeHelper(inorder, postorder, postIndex - 1,
				index + 1, inEnd);
		root.left = buildTreeHelper(inorder, postorder, postIndex - (inEnd - index) - 1,
				inStart, index - 1);
		return root;
	}
}
