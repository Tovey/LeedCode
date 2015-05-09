package xtu.cie.ldj;

public class TrappingRainWater {
	public int trap(int[] height) {
		if(height.length <= 2) return 0;
		
		int sum = 0;
		int l = 1,r = height.length - 2;
		int max_l = height[0],max_r = height[r + 1];
		
		while(l <= r){
			if(max_l < max_r){
				if(height[l] >= max_l){
					max_l = height[l];
				}else {
					sum += max_l - height[l];
				}
				l ++;
			}else{
				if(height[r] >= max_r){
					max_r = height[r];
				}else {
					sum += max_r - height[r];
				}
				r --;
			}
		}
		
		return sum;
	}
}
