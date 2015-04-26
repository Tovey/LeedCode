package xtu.cie.ldj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
	
	/**
	 * Accepted:300ms
	 */
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while(root != null){
			list.add(root.val);
			if(root.right != null){
				stack.push(root.right);
			}
			root = root.left;
			if(root == null && !stack.isEmpty()){
				root = stack.pop();
			}
		}
		
		return list;
	}
	/**
	 * Accepted:244ms
	 */
	public List<Integer> preorderTraversal_2(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		LinkedList<TreeNode> l_r = new LinkedList<TreeNode>();
		while(root != null){
			list.add(root.val);
			if(root.right != null){
				l_r.add(root.right);
			}
			
			root = root.left;
			
			if(root == null && l_r.size() != 0){
				root = l_r.get(l_r.size() - 1);
				l_r.remove(l_r.size() - 1);
			}
		}
		
		return list;
	}
	
	private void preOrderTraversalRecursive(List<Integer> l,TreeNode root){
		if (root != null) {
			l.add(root.val);
			preOrderTraversalRecursive(l,root.left);
			preOrderTraversalRecursive(l,root.right);
		}
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
