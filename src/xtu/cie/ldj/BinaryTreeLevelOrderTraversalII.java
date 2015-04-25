package xtu.cie.ldj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalII {
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

	// use recursion
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> listList = new ArrayList<List<Integer>>();
		traversal(listList, root, 1);
		
		int i = 0;
		int j = listList.size() - 1;
		List<Integer> tmp;
		while(i < j){
			tmp = listList.get(i);
			listList.set(i, listList.get(j));
			listList.set(j, tmp);
			i ++;
			j --;
		}
		
		return listList;
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
