package xtu.cie.ldj;

public class LongestPalindromicSubstring {
	// http://blog.csdn.net/hopeztm/article/details/7932245
	
	// 最长回文字符串，动态规划，时间复杂度为 O(n^2)
    public static String longestPalindromeUseDynamicProgramming(String s) {
    	if (s.length() <= 1) return s;
    	
    	int len = s.length();
    	boolean[][] dp = new boolean[len][len];
    	
    	for (int i = 0; i < len - 1; i++) {
    		dp[i][i] = true;
    		if (s.charAt(i) == s.charAt(i+1)) {
				dp[i][i+1] = true;
			}
    	}
    	dp[len-1][len-1] = true;
    	
    	for (int i = 2; i < len; i++) {
			for (int j = 0; j < len - i; j++) {
				int k = j + i;
				
				if(s.charAt(j) == s.charAt(k)){
					dp[j][k] = dp[j+1][k-1];
				}else {
					dp[j][k] = false;
				}
			}
		}

    	int max_i = 0,max_j = 0,max_length = 0;
    	
    	for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				
				if (dp[i][j]) {
					if (j - i + 1 > max_length) {
						max_length = j - i + 1;
						max_i = i;
						max_j = j;
					}
				}
			}
		}
        return s.substring(max_i, max_j + 1);
    }
    
    public static void print(String str,String sub) {
		System.out.println(str);
		int index = str.indexOf(sub);
		for (int i = 0; i < index; i++) {
			System.out.print(" ");
		}
		System.out.println(sub);
	}
    
    public static void printTwoDimArray(boolean A[][],int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(A[i][j] + "\t");
			}
			System.out.println();
		}
	}
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str0 = "ababcbaba";
		//String str1 = "bb";
		
		print(str0, longestPalindromeUseDynamicProgramming(str0));
	}

}
