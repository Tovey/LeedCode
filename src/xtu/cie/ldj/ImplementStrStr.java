package xtu.cie.ldj;

public class ImplementStrStr {
	
	// KMP
    public int strStr(String haystack, String needle) {
    	int[] next = calculateNext(needle);
    	
    	int index = 0;
    	int i = 0;
    	while(i < needle.length() && index < haystack.length()){
    		if(i == -1 || needle.charAt(i) == haystack.charAt(index)){
    			index ++;
    			i ++;
    		}else{
    			i = next[i];
    		}
    	}
    	if(i == needle.length())
    		return index - i;
    	return -1;
    }
    
    private int[] calculateNext(String str){
    	if(str == null || str.length() == 0)
    		return null;
    	int[] next = new int[str.length()];
    	next[0] = -1;
    	int k = next[0];
    	int j = 0;
    	while(j < str.length() - 1){
    		if(k == -1 || str.charAt(j) == str.charAt(k)){
    			k ++;
    			j ++;
    			next[j] = k;
    		}else {
				k = next[k];
			}
    	}
    	return next;
    }
}
