package xtu.cie.ldj;


public class ConstructBinaryTreefromPreorderandInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    	return buildTreeHelper(preorder, inorder, 0, 0, inorder.length - 1);
    }
    
    private TreeNode buildTreeHelper(int[] preorder,int[] inorder,int preStart,int inStart,int inEnd){
    	if (preStart > preorder.length - 1 || inStart > inEnd) {
			return null;
		}
    	TreeNode root = new TreeNode(preorder[preStart]);
    	int index = inStart;
    	for(int i = index; i <= inEnd; i++){
    		if(inorder[i] == root.val){
    			index = i;
    			break;
    		}
    	}
    	
    	root.left = buildTreeHelper(preorder,inorder,preStart + 1,inStart,index - 1);
    	root.right = buildTreeHelper(preorder, inorder, preStart + index - inStart + 1, index + 1, inEnd);
    	return root;
    }
}
