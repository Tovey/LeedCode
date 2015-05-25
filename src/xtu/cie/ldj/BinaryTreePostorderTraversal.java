package xtu.cie.ldj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {
	// Iterator
	public List<Integer> postorderTraversal(TreeNode root) {
		ArrayList<Integer> postOrderList = new ArrayList<Integer>();
		postOrderTraversalIteratively(root, postOrderList);
		return postOrderList;
	}

	private void postOrderTraversalIteratively(TreeNode root,
			ArrayList<Integer> list) {
		if (root != null) {
			postOrderTraversalIteratively(root.left, list);
			postOrderTraversalIteratively(root.right, list);
			list.add(root.val);
		}
	}

	// Recursive
	public List<Integer> postorderTraversal_2(TreeNode root) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (root != null) {
			list.addFirst(root.val);
			if (root.left != null) {
				stack.push(root.left);
			}
			root = root.right;
			if (root == null && !stack.isEmpty()) {
				root = stack.pop();
			}
		}

		return list;
	}

	// Recursive
	public List<Integer> postorderTraversal_3(TreeNode root) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if(root != null)
			stack.push(root);
		TreeNode tmpNode = null;
		while (!stack.isEmpty()) {
			tmpNode = stack.pop();
			list.addFirst(tmpNode.val);
			if(tmpNode.left != null)
				stack.push(tmpNode.left);
			if(tmpNode.right != null)
				stack.push(tmpNode.right);
		}

		return list;
	}
}
