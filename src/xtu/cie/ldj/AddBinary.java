package xtu.cie.ldj;

public class AddBinary {
	/**
	 * Accepted:309ms
	 */
	public String addBinary(String a, String b) {
		String str = "";
		int c = 0, i = a.length() - 1, j = b.length() - 1;
		
		while(i >= 0 || j >= 0 || c == 1){
			c += i >= 0 ? a.charAt(i --) - '0' : 0;
			c += j >= 0 ? b.charAt(j --) - '0' : 0;
			char ch = (char)(c % 2 + '0');
			str =  ch + str;
			c /= 2;
		}
		return str;
	}
	
	/**
	 * Accepted:316ms
	 */
	public String addBinary2(String a, String b) {
		int c = 0, i = a.length() - 1, j = b.length() - 1;
		char[] chs = (i > j) ? (new char[i+1]) : (new char[j+1]);
		int t = chs.length - 1;
		while(i >= 0 || j >= 0){
			c += i >= 0 ? a.charAt(i --) - '0' : 0;
			c += j >= 0 ? b.charAt(j --) - '0' : 0;
			chs[t --] = (char)(c % 2 + '0');
			c >>= 1;
		}
		
		if(c == 1){
			return "1" + String.valueOf(chs);
		}
		return String.valueOf(chs);
	}
	
	/**
	 * Accepted:280ms
	 */
	public String addBinary3(String a, String b) {
		if(a.length() < b.length()){
			String tmp = a;
			a = b;
			b = tmp;
		}
		
		int c = 0;
		char[] chs = a.toCharArray();
		int i = chs.length - 1;
		int j = b.length() - 1;
		
		while(i >= 0 || j >= 0){
			c += i >= 0 ? chs[i] - '0' : 0;
			c += j >= 0 ? b.charAt(j --) - '0' : 0;
			chs[i --] = (char)(c % 2 + '0');
			c >>= 1;
		}
		
		if(c == 1){
			return "1" + String.valueOf(chs);
		}
		return String.valueOf(chs);
	}
	/**
	 * Accepted	293 ms
	 */
	public String addBinary4(String a, String b) {
		if(a == null || a.length() == 0) return b;
		if(b == null || b.length() == 0) return a;
		
		int c = 0, i = a.length() - 1, j = b.length() - 1;
		StringBuilder str = new StringBuilder();
		while(i >= 0 || j >= 0 || c == 1){
			c += i >= 0 ? a.charAt(i --) - '0' : 0;
			c += j >= 0 ? b.charAt(j --) - '0' : 0;
			str.insert(0,(char)(c % 2 + '0'));
			c >>= 1;
		}
		return str.toString();
	}

	public static void main(String[] args) {
		AddBinary add = new AddBinary();
		System.out.println(add.addBinary4("0", "1"));
	}
}