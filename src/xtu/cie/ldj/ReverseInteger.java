package xtu.cie.ldj;

public class ReverseInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverse(123) + "");
		System.out.println(reverse(-123) + "");
	}
	
	public static int reverse(int x){
		int flag = 1;
		if (x == 0) return 0;
		else if(x < 0) {
			flag = -1;
			x *= -1;
		}
		
		int result = 0;
		while(x != 0){
			result = result * 10 + x % 10;
			x = x / 10;
		}
		
		return result * flag;
	}
	
	private static void print(String str){
		System.out.println(str);
	}
}
