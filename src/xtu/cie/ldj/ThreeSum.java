package xtu.cie.ldj;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		int start,end,temp;
		
		for (int i = 0; i < nums.length; i++) {
			if (i != 0 && nums[i] == nums[i-1]) continue;
			int cur = nums[i];
			start = i + 1;
			end = nums.length - 1;
			
			while(start < end){
				if(start != i + 1 && nums[start] == nums[start - 1]) {
					start ++;
					continue;
				}
				temp = nums[start] + nums[end];
				if(temp == -cur){
					List<Integer> list = new ArrayList<Integer>(3);
					list.add(cur);
					list.add(nums[start]);
					list.add(nums[end]);
					lists.add(list);
					start ++;
					end --;
				}else if(temp > -cur){
					end --;
				}else {
					start ++;
				}
			}
		}
		
		return lists;
	}
}
