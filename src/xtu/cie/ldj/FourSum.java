package xtu.cie.ldj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		
		int start,end;
		for (int i = 0; i < nums.length - 3; i++) {
			if(i != 0 && nums[i] == nums[i - 1]) continue;
			for (int j = i + 1; j < nums.length - 2; j++) {
				if(j != i + 1 && nums[j] == nums[j - 1]) continue;
				start = j + 1;
				end = nums.length - 1;
				while(start < end){
					if(start != j + 1 && nums[start] == nums[start - 1]){
						start ++;
						continue;
					}
					
					int tmp = nums[i] + nums[j] + nums[start] + nums[end];
					if(tmp == target){
						ArrayList<Integer> list = new ArrayList<Integer>(4);
						list.add(nums[i]);
						list.add(nums[j]);
						list.add(nums[start]);
						list.add(nums[end]);
						lists.add(list);
						start ++;
						end --;
					}else if(tmp < target){
						start ++;
					}else {
						end --;
					}
				}
			}
		}
		
		return lists;
	}
}
