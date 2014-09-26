package xtu.cie.ldj;

import java.util.HashMap;

public class TwoSumTest {
	
    public static int[] twoSum(int[] numbers, int target) {
    	int[] result = new int[2];
    	
    	HashMap<Integer, Integer> hashMap = new HashMap<Integer,Integer>();
    	
    	for(int i = 0; i < numbers.length; i++){
    		if (hashMap.containsKey(numbers[i])) {
				int index = hashMap.get(numbers[i]);
				result[0] = index + 1;
				result[1] = i + 1;
    			break;
			}else {
				hashMap.put(target - numbers[i], i);
			}
    	}
    	
    	return result;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		int [] testData = new int[32044 / 2 + 1];
		
		int count = 0;
		for (int i = 0; i <= 32044; i++) {
			if(i % 2 == 0){
				testData[count++] = i;
			}
		}
		int target = 16021;
		*/
		int[] testData = {-3,4,3,90};
		int target = 0;
		
		int[] result = new int[2];
		result = twoSum(testData, target);
		
		System.out.println("\n" + result[0] + "  " + result[1]);
		System.out.println("\n" + testData[result[0]-1] + "  " + testData[result[1]-1]);
	}

}
