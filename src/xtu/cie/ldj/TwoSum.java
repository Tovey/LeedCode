package xtu.cie.ldj;

import java.util.HashMap;
/**
 * 数组不一定有序，不能用二分查找
 */
public class TwoSum {
	
    public static int[] twoSum(int[] numbers, int target) {
    	HashMap<Integer, Integer> hashMap = new HashMap<Integer,Integer>();
    	
    	for(int i = 0; i < numbers.length; i++){
    		if (hashMap.containsKey(numbers[i])) {
				return new int[]{hashMap.get(numbers[i]),i + 1};
			}else {
				hashMap.put(target - numbers[i], i + 1);
			}
    	}
    	
    	return new int[]{-1,-1};
    }

}
