package xtu.cie.ldj;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        int maxLen = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int n : nums){
        	if(!map.containsKey(n)){
        		int left = (map.containsKey(n - 1)) ? map.get(n - 1) : 0;
        		int right = (map.containsKey(n + 1)) ? map.get(n + 1) : 0;
        		int sum = left + right + 1;
        		map.put(n, sum);
        		map.put(n - left, sum);
        		map.put(n + right, sum);
        		
        		if(maxLen < sum)
        			maxLen = sum;
        	}else{
        		continue; // duplicates
        	}
        }
        
        return maxLen;
    }
    
    public int longestConsecutive_2(int[] nums) {
        int maxLen = 0;
        Set<Integer> set = new HashSet<Integer>(nums.length);
        for (int n:nums) {
        	set.add(n);
		}
		
        for (int n:nums) {
        	int len = 1;
        	int t = n - 1;
        	while(set.contains(t)){
        		set.remove(t);
        		len ++;
        		t --;
        	}
        	t = n + 1;
        	while(set.contains(t)){
        		set.remove(t);
        		len ++;
        		t ++;
        	}

        	if (len > maxLen) {
				maxLen = len;
			}
		}
        
        return maxLen;
    }
    
}
