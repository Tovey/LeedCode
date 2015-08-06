package xtu.cie.ldj;

public class MinimumDepthofBinaryTree {
	public int minDepth(TreeNode root) {
		if(root == null) return 0;
		if(root.right == null && root.left == null)	return 1;
		if(root.left == null)
			return minDepth(root.right) + 1;
		if(root.right == null)
			return minDepth(root.left) + 1;
		int leftDepth = minDepth(root.left) + 1;
		int rightDepth = minDepth(root.right) + 1;
		return leftDepth > rightDepth ? rightDepth : leftDepth;
	}
	
	
	public int minDepth01(TreeNode root) {
		if(root == null) return 0;
		minDep = Integer.MAX_VALUE;
		minDepthHelper(root,0);
        return minDep;
    }
	
	private void minDepthHelper(TreeNode root,int dep){
		if((root.left == null && root.right == null)){
			if(minDep > dep + 1){
				minDep = dep + 1;
			}
			return;
		}
		if(root.left != null)
			minDepthHelper(root.left,dep + 1);
		if(root.right != null)
			minDepthHelper(root.right,dep + 1);
	}
	
	int minDep = Integer.MAX_VALUE;
	
}
