package xtu.cie.ldj;

import java.util.ArrayList;

public class BinaryTreeTraversal {
	class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
	
	ArrayList<Integer> postOrderList = new ArrayList<Integer>();
	
	public ArrayList<Integer> postorderTraversal(TreeNode root) {
		postOrderTraversalIteratively(root);
		return this.postOrderList;
	}
	
	private void postOrderTraversalIteratively(TreeNode root){
		if (root != null) {
			postOrderTraversalIteratively(root.left);
			postOrderTraversalIteratively(root.right);
			postOrderList.add(root.val);
		}
	}
	
	ArrayList<Integer> preOrderList = new ArrayList<Integer>();
	
	public ArrayList<Integer> preorderTraversal(TreeNode root) {
		preOrderTraversalIteratively(root);
		return this.postOrderList;
	}
	
	private void preOrderTraversalIteratively(TreeNode root){
		if (root != null) {
			preOrderList.add(root.val);
			preOrderTraversalIteratively(root.left);
			preOrderTraversalIteratively(root.right);
		}
	}
}
