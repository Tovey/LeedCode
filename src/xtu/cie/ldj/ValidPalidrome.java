package xtu.cie.ldj;

public class ValidPalidrome {
	/**
	 * Accepted:350ms
	 */
    public boolean isPalindrome(String s) {
        if(s == null || s.length() <= 1) return true;
		int start = 0,end = s.length() - 1;
		while(start <= end){
			if(!isLetter(s.charAt(start))){
				start ++;
				continue;
			}
			if(!isLetter(s.charAt(end))){
				end --;
				continue;
			}
			if(toLowerLetter(s.charAt(start)) == toLowerLetter(s.charAt(end))){
				start ++;
				end --;
			}else {
				return false;
			}
		}
		return true;
    }
    
    private char toLowerLetter(char ch){
		if((ch >= 'A' && ch <= 'Z'))
			return (char)(ch + ('a' - 'A'));
		return ch;
	}
	
	private boolean isLetter(char ch){
		if((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9'))
			return true;
		else return false;
	}
	
}
