package xtu.cie.ldj;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		pathListLists = new ArrayList<List<Integer>>();
        if(root != null)
        	pathSumHelper(root,sum);
        return pathListLists;
    }
	
	private void pathSumHelper(TreeNode root, int sum){
		if(root == null) return;
		
		pathList.add(root.val);
		
		if(root.left == null && root.right == null && root.val == sum){
			pathListLists.add(new ArrayList(pathList));
        	pathList.remove(pathList.size() - 1);
        	return;
        }
		pathSumHelper(root.left, sum - root.val);
		pathSumHelper(root.right, sum - root.val);
        pathList.remove(pathList.size() - 1);
	}
	
	private ArrayList<Integer> pathList = new ArrayList<Integer>(100);
	private List<List<Integer>> pathListLists = null;
}
