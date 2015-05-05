package xtu.cie.ldj;

import java.util.Arrays;

public class ThreeSumClosest {
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int res = 0;
		int min_gap = Integer.MAX_VALUE;
		int start, end, tmp;
		for (int i = 0; i < nums.length - 2; i++) {
			if (i != 0 && nums[i] == nums[i - 1])
				continue;
			start = i + 1;
			end = nums.length - 1;

			while (start < end) {
				tmp = nums[start] + nums[end] + nums[i];
				int gap = Math.abs(tmp - target);
				
				if(gap < min_gap){
					res = tmp;
					min_gap = gap;
				}
				
				if(tmp < target)	start++;
				else end --;
			}
		}

		return res;
	}
}
