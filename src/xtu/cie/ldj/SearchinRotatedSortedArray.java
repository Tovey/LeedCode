package xtu.cie.ldj;

public class SearchinRotatedSortedArray {
	
	public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        int s = 0,e = nums.length - 1;
        while(s < e){
        	int mid = (s + e) / 2;
        	if(nums[mid] > nums[e]) s = mid + 1;
        	else e = mid;
        }
        int rot = s;
        s = 0; e = nums.length - 1;
        while(s <= e){
        	int mid = (s + e) / 2;
        	int tmp = (mid + rot) % nums.length;
        	if(nums[tmp] == target) return tmp;
        	else if (nums[tmp] < target) s = mid + 1;
        	else e = mid - 1;
        }
        return -1;
    }
	
	public int search_2(int[] nums, int target) {
		int s = 0,e = nums.length - 1;
		while(s <= e){
			int mid = (s + e) / 2;
			if(nums[mid] == target) return mid;
			if(nums[s] <= nums[mid]){
				if(nums[s] <= target && target < nums[mid])
					e = mid - 1;
				else s = mid + 1;
			}else{
				if(nums[mid] < target && target <= nums[e])
					s = mid + 1;
				else e = mid - 1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		SearchinRotatedSortedArray s = new SearchinRotatedSortedArray();
		int[] nums = {1,3};
		System.out.println("" + s.search(nums, 3));
	}
}
