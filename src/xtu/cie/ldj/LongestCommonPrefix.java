package xtu.cie.ldj;

public class LongestCommonPrefix {
	/**
	 * Accepted	286 ms
	 */
	public String longestCommonPrefix_1(String[] strs) {
		if(strs.length == 0) return "";
    	if(strs.length == 1) return strs[0];
    	
    	StringBuilder s = new StringBuilder();
    	
    	for(int i = 0; i < strs[0].length(); i++){
    		char ch = strs[0].charAt(i);
    		for (int j = 1; j < strs.length; j++) {
				if(strs[j].length() < i + 1 || ch != strs[j].charAt(i))
					return s.toString();
			}
    		s.append(ch);
    	}
    	return s.toString();
	}
	
	/**
	 * Accepted	342 ms
	 */
    public String longestCommonPrefix(String[] strs) {
    	if(strs.length == 0) return "";
    	if(strs.length == 1) return strs[0];
    	
    	StringBuilder s = new StringBuilder();
    	int c = 0;
    	while(true){
    		int i = 0;
    		for(;i < strs.length && strs[i].length() > c;i++){
    			if(strs[i].charAt(c) != strs[0].charAt(c))
    				break;
    		}
    		
    		if(i == strs.length){
    			s.append(strs[0].charAt(c));
    			c ++;
    		}else{
    			break;
    		}
    	}
        
        return s.toString();
    }
}
