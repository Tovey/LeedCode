package xtu.cie.ldj;

public class ConvertSortedArraytoBinarySearchTree {
	
	public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBSTHelper(nums,0,nums.length - 1);
    }
	
	private TreeNode sortedArrayToBSTHelper(int[] nums,int left,int right){
		if(left > right){
			return null;
		} else if(left == right) {
			return new TreeNode(nums[left]);
		}
		
		int mid = (left + right) / 2;
		TreeNode node = new TreeNode(nums[mid]);
		node.left = sortedArrayToBSTHelper(nums, left, mid - 1);
		node.right = sortedArrayToBSTHelper(nums, mid + 1, right);
		
		return node;
	}
}
