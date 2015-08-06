package xtu.cie.ldj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class UniqueBinarySearchTreesII {
	public List<TreeNode> generateTrees(int n) {
        return genTrees(1, n);
    }
    
    private List<TreeNode> genTrees(int start, int end) {
		List<TreeNode> list = new ArrayList<TreeNode>();

		if (start > end){
		    list.add(null);
			return list;
		}

		List<TreeNode> left, right;
		for (int i = start; i <= end; i++) {
			left = genTrees(start, i - 1);
			right = genTrees(i + 1, end);

			for (TreeNode lNode : left) {
				for(TreeNode rNode : right){
					TreeNode root = new TreeNode(i);
					root.left = lNode;
					root.right = rNode;
					list.add(root);
				}
			}
		}

		return list;
	}
    
    public List<TreeNode> generateTrees02(int n) {
        List<TreeNode>[] result = new List[n+1];
        result[0] = new ArrayList<TreeNode>();
        result[0].add(null);
        
        for(int len = 1; len <= n; len ++){
        	result[len] = new ArrayList<TreeNode>();
        	for(int j = 0; j < len ; j++){
        		for(TreeNode nodeL : result[j]){
        			for(TreeNode nodeR : result[len - j - 1]){
        				TreeNode node = new TreeNode(j + 1);
        				node.left = nodeL;
        				node.right = clone(nodeR,j+1);
        				result[len].add(node);
        			}
        		}
        	}
        }
        
        return result[n];
    }
    
    private TreeNode clone(TreeNode node,int offset){
    	if(node == null) return null;
    	TreeNode tmpNode = new TreeNode(node.val + offset);
    	tmpNode.left = clone(node.left, offset);
    	tmpNode.right = clone(node.right, offset);
    	return tmpNode;
    }
    
    
    public static void main(String[] args) {
    	UniqueBinarySearchTreesII trees = new UniqueBinarySearchTreesII();
    	List<TreeNode> lists = trees.generateTrees(5);
    	System.out.println(lists.size());
	}
}
