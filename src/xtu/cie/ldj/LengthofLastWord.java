package xtu.cie.ldj;

public class LengthofLastWord {
	/**
	 * Accepted	253 ms
	 */
	public int lengthOfLastWord(String s) {
		int len = s.length() - 1;
		int c = 0;
		while(len >= 0 && s.charAt(len) == ' ') len --;
		
		while(len >= 0 && s.charAt(len) != ' '){
			c ++;
			len --;
		}
		
		return c;
	}
	
	/**
	 * Accepted	294 ms
	 */
	public int lengthOfLastWord_2(String s) {
        String[] ss = s.split(" ");
 		if(ss.length == 0) return 0;
 		else{
 		    return ss[ss.length - 1].length();
 		}
    }
	
	public static void main(String[] args) {
		LengthofLastWord l = new LengthofLastWord();
		
		System.out.println(l.lengthOfLastWord("Hello WOrld  "));
	}
}
