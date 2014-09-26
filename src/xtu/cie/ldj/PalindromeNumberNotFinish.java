package xtu.cie.ldj;

public class PalindromeNumberNotFinish {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test(0);
	}
	
	public static void test(int x){
		System.out.println(x + "\t:\t" + isPalindrome(x));
	}

	public static boolean isPalindrome(int x) {
		boolean flag = false;
		String str = Integer.toString(x);
		int i = 0,j = str.length() - 1;
		while (i <= j) {
			if (str.charAt(i) == str.charAt(j)) {
				i ++;
				j --;
			}else {
				break;
			}
		}
		
		if (i >= j) {
			flag = true;
		}
		
		return flag;
	}
	
	public static boolean isPalindrome2(int x) {
		int y = 0;
		int temp = x;
//		while(temp) {
//			
//		}
		
		return false;
	}
}
