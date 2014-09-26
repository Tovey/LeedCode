package xtu.cie.ldj;

public class ZigZagConversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(convert("PAYPALISHIRING", 3));
		System.out.println(convert("ABCDEFGHIJKLMN", 4));

	}

	public static String convert(String s, int nRows) {
		if(nRows == 1 || s.length() <= 1)
			return s;
		
		char[] result = new char[s.length()];
		int r = 0;
		for (int i = 0; i < nRows; i++) {
			int c = i, flag = 0;
			while (c < s.length()) {
				result[r++] += s.charAt(c);
				if (i == (nRows - 1))
					flag = 1;
				if (flag == 0 || i == 0) {
					c += ((nRows - 1) - i) * 2;
					flag = 1;
				} else {
					c += i * 2;
					flag = 0;
				}
			}
		}

		return String.copyValueOf(result);
	}
}
