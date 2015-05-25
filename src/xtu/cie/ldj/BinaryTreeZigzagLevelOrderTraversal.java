package xtu.cie.ldj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		if (root == null)
			return lists;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();

		queue.add(root);
		boolean flag = false;
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
			
			if(flag){
				int l = 0,r = subList.size() - 1;
				while(l <= r){
					Integer tmp = subList.get(l);
					subList.set(l ++, subList.get(r));
					subList.set(r --, tmp);
				}
			}
			
			lists.add(subList);
			flag = !flag;
		}

		return lists;
	}
}
