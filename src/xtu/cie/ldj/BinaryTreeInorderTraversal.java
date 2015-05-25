package xtu.cie.ldj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
	
	private void inorderTraversalIterate(TreeNode root,LinkedList<Integer> list){
		if(root == null)
			return;
		inorderTraversalIterate(root.left,list);
		list.add(root.val);
		inorderTraversalIterate(root.right,list);
	}
	
	// using iterate
    public List<Integer> inorderTraversal(TreeNode root) {
    	LinkedList<Integer> list = new LinkedList<Integer>();
    	inorderTraversalIterate(root,list);
    	return list;
    }
    
    // using Recursive  ArrayList
    public List<Integer> inorderTraversal_2(TreeNode root) {
    	LinkedList<Integer> list = new LinkedList<Integer>();
    	if(root == null)
    		return list;
    	ArrayList<TreeNode> listTmp = new ArrayList<TreeNode>();
    	
    	while(root != null){
    		if(root.left != null){
    			TreeNode tmp = root.left;
    			root.left = null;
    			listTmp.add(root);
    			root = tmp;
    			continue;
    		}
    		
    		list.add(root.val);
    		root = root.right;
    		if(root == null && listTmp.size() != 0){
    			root = listTmp.get(listTmp.size() - 1);
    			listTmp.remove(listTmp.size() - 1);
    		}
    	}
    	return list;
    }
    
    public List<Integer> inorderTraversal_3(TreeNode root) {
    	List<Integer> list = new LinkedList<Integer>();
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	TreeNode curNode = root;
    	while(curNode != null || !stack.isEmpty()){
    		while(curNode != null){
    			stack.add(curNode);
    			curNode = curNode.left;
    		}
    		curNode = stack.pop();
    		list.add(curNode.val);
    		curNode = curNode.right;
    	}
    	return list;
    }
}
