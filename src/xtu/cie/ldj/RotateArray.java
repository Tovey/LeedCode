package xtu.cie.ldj;

public class RotateArray {
	public void rotate_range(int[] nums, int s, int e) {
		int t;
		while (s <= e) {
			t = nums[s];
			nums[s++] = nums[e];
			nums[e--] = t;
		}
	}

	public void rotate(int[] nums, int k) {
		k %= nums.length;
		if (k == 0)
			return;
		rotate_range(nums, 0, nums.length - k - 1);
		rotate_range(nums, nums.length - k, nums.length - 1);
		rotate_range(nums, 0, nums.length - 1);
	}
}
