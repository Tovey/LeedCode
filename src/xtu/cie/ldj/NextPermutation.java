package xtu.cie.ldj;

import java.util.Arrays;

public class NextPermutation {
	/**
	 * 1、从右至左，找到第一个小于右边的数
	 * 2、找到右边的数中，大于该数的最小的数，进行交换
	 * 3、对右边的数进行排序
	 */
	public void nextPermutation(int[] nums) {
		int maxR = nums.length - 1;
		int i;
		for (i = nums.length - 2; i >= 0; i--) {
			if(nums[maxR] <= nums[i]) {
				maxR = i;
				continue;
			}else{
				for(int j = nums.length - 1; j > i; j--){
					if(nums[i] < nums[j]){
						int tmp = nums[i];
						nums[i] = nums[j]; 
						nums[j] = tmp;
						break;
					}
				}
				Arrays.sort(nums,i + 1, nums.length);
				return;
			}
		}
		
		if(maxR == 0){
			int start = 0,end = nums.length - 1;
			int tmp;
			while(start < end){
				tmp = nums[start];
				nums[start++] = nums[end];
				nums[end--] = tmp;
			}
		}
	}
	
	public void nextPermutation2(int[] nums) {
		int i = nums.length - 1;
		while(i > 0 && nums[i - 1] >= nums[i]) i--;
		Arrays.sort(nums,i,nums.length);
		if(i == 0) return;
		int j = i--;
		while(nums[j] <= nums[i]) j++;
		// swap
		int t = nums[j];
		nums[j] = nums[i];
		nums[i] = t;
	}
	
	public static void main(String[] args) {
		NextPermutation np = new NextPermutation();
		int[] nums = {1,3,2};
		np.nextPermutation(nums);
		for(int i:nums)
			System.out.print(" " + i);
		System.out.println();
	}
}
