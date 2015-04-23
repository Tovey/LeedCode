package xtu.cie.ldj;

import java.util.HashMap;
/**
 * 数组不一定有序，不能用二分查找
 */
public class TwoSum {
	public static int[] twoSum2(int[] numbers,int target){
		int[] result = new int[2];
		for (int i = 0; i < numbers.length; i++) {
			int j = binarySearch(numbers, 0, i, numbers[i]);
			if (j == -1) {
				numbers[i] = target - numbers[i];
			}else{
				result[0] = j + 1;
				result[1] = i + 1;
				break;
			}
		}
		
		return result;
	}
	
	private static int binarySearch(int[] arr,int s,int e,int target){
		int l = s,r = e;
		while(l < r){
			int mid = (l + r ) / 2;
			if(arr[mid] == target){
				return mid;
			}else if(arr[mid] < target){
				l = mid + 1;
			}else{
				r = mid - 1;
			}
		}
		
		return -1;
	}
	
	
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
	
	
	public static void main(String[] args) {
//		int[] testData = {-3,4,3,90};
		int[] testData = {0,4,3,0};
		int target = 0;
		
		int[] result = new int[2];
		result = twoSum2(testData, target);
		
		System.out.println(result[0] + "  " + result[1]);
//		System.out.println("\n" + testData[result[0]-1] + "  " + testData[result[1]-1]);
	}

}
