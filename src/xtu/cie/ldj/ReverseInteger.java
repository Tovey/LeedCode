package xtu.cie.ldj;

public class ReverseInteger {
	
	// Accepted:237ms
	// decrease the multiple
	public int reverse_1(int x) {
 		boolean flag = false;
 		if(x < 0){
 		    x = -x;
 		    flag = true;
 		}
 		
 		long res = 0;
 		while(x != 0){
 		    res *= 10;
 		    if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE)
 		        return 0;
 		    res += x % 10;
 		    x /= 10;
 		}
 		
 		if(flag)
 		    return (int)-res;
 		else
 		    return (int)res;
    }
	
	// Accepted:484ms
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
}
