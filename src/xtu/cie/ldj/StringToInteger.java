package xtu.cie.ldj;

import java.util.ArrayList;

public class StringToInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println(atoi("   -0123asd") + "");
		// System.out.println(atoi("   -2147483688") + "");
		System.out.println(atoi("2147483648") + "");
	}

	/**
	 * 考虑下面情况： 1、存在空格，但是可以转换 2、格式无效 3、数据溢出
	 */
	public static int myAtoi(String str) {
		if (str == null || str.length() == 0)
			return 0;
		int max = Integer.MAX_VALUE / 10;
		int res = 0, i = 0;
		while (str.charAt(i) == ' ')
			i++;
		boolean flag = (str.charAt(i) == '-') ?true:false;
		if(str.charAt(i) == '-' || str.charAt(i) == '+') i++;
		char tmp ;
		while(i < str.length()){
			tmp = str.charAt(i);
			if(tmp < '0' || tmp > '9')
				break;
			if(res > max || (res == max) && tmp > '7'){
				return flag ? Integer.MIN_VALUE : Integer.MAX_VALUE;
			}
			res = res * 10 + tmp - '0';
			i ++;
		}
		
		if(flag)
			return -res;
		else
			return res;
	}

	static int INT_MAX = 2147483647;
	static int INT_MIN = -2147483648;

	public static int atoi(String str) {
		String s = str;
		int i;
		int is_pos = 1, result = 0;

		String[] st = s.split(" ");
		for (i = 0; i < st.length; i++)
			if (st[i].length() != 0) {
				s = st[i];
				break;
			}

		if (s.length() == 0) {
			return 0;
		}

		if (s.charAt(0) == '-')
			is_pos = -1;
		if (s.charAt(0) == '+' || s.charAt(0) == '-')
			s = s.substring(1);

		int start = 0, end = 0;
		while (start < s.length() && s.charAt(start) == '0')
			start++;
		end = start;
		while (end < s.length() && s.charAt(end) >= '0' && s.charAt(end) <= '9') {
			result = result * 10 + (s.charAt(end) - '0');
			end++;
		}
		s = s.substring(start, end);

		int flag = 0;

		if (s.length() > 10) {
			flag = is_pos;
		} else if (s.length() == 10) {
			if (is_pos == 1 && s.compareTo("2147483647") > 0) {
				flag = 1;
			} else if (is_pos == -1 && s.compareTo("2147483648") > 0) {
				flag = -1;
			} else
				flag = 0;
		}

		if (flag == 1)
			return 2147483647;
		else if (flag == -1)
			return -2147483648;
		else
			return is_pos * result;
	}
}
