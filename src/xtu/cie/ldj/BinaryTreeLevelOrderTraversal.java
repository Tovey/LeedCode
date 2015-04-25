package xtu.cie.ldj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
	public void traversal(List<List<Integer>> listList, TreeNode root,
			int deepth) {
		if (root == null)
			return;

		if (listList.size() < deepth) {
			listList.add(new ArrayList<Integer>());
		}

		listList.get(deepth - 1).add(root.val);

		traversal(listList, root.left, deepth + 1);
		traversal(listList, root.right, deepth + 1);
	}

	// Accepted:264ms
	// use recursion
	public List<List<Integer>> levelOrder_1(TreeNode root) {
		List<List<Integer>> listList = new ArrayList<List<Integer>>();
		traversal(listList, root, 1);
		return listList;
	}

	// Accepted:293ms
	// use queue
	public List<List<Integer>> levelOrder_2(TreeNode root) {
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		if (root == null)
			return lists;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();

		queue.add(root);
		while (queue.size() != 0) {
			int level = queue.size();
			List<Integer> subList = new ArrayList<Integer>();
			for (int i = 0; i < level; i++) {
				if (queue.peek().left != null)
					queue.offer(queue.peek().left);
				if (queue.peek().right != null)
					queue.offer(queue.peek().right);
				subList.add(queue.poll().val);
			}
			lists.add(subList);
		}

		return lists;
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
