package xtu.cie.ldj;

public class FlattenBinaryTreetoLinkedList {
	public void flatten_2(TreeNode root) {
		TreeNode tmpNode = root;
		while(tmpNode != null){
			if(tmpNode.left != null){
				TreeNode preNode = tmpNode.left;
				while (preNode.right != null) {
					preNode = preNode.right;
				}
				preNode.right = tmpNode.right;
				tmpNode.right = tmpNode.left;
				tmpNode.left = null;
			}
			tmpNode = tmpNode.right;
		}
	}
	
	private TreeNode preNode = null;
	public void flatten(TreeNode root){
		if (root == null)	return;
		
		TreeNode lastRight = root.right;
		if(preNode != null){
			preNode.left = null;
			preNode.right = root;
		}
		preNode = root;
		flatten(root.left);
		flatten(lastRight);
	}
}
