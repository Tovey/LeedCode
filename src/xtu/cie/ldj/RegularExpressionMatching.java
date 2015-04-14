package xtu.cie.ldj;

public class RegularExpressionMatching {

	public boolean isMatch_1(final String s, int sStart, final String p,
			int pStart) {
		int sLen = s.length(), pLen = p.length();

		if (pStart == pLen)
			return sStart == sLen;

		if (pStart == pLen - 1 || p.charAt(pStart + 1) != '*') {
			if (sStart > sLen - 1
					|| (p.charAt(pStart) != '.' && s.charAt(sStart) != p
							.charAt(pStart)))
				return false;

			return isMatch_1(s, sStart + 1, p, pStart + 1);
		} else {
			int i = sStart - 1;
			while (i < sLen
					&& (i == sStart - 1 || p.charAt(pStart) == '.' || p
							.charAt(pStart) == s.charAt(i))) {
				if (isMatch_1(s, i + 1, p, pStart + 2))
					return true;
				i++;
			}
			return false;
		}
	}
	

	public boolean isMatch(String s, String p) {
		return isMatch_1(s, 0, p, 0);
	}
	
	public static void main(String[] args) {
		RegularExpressionMatching test = new RegularExpressionMatching();
		System.out.println(test.isMatch("aa", "a")); // false
		System.out.println(test.isMatch("aa", "aa")); // true
		System.out.println(test.isMatch("aaa", "aa")); // false
		System.out.println(test.isMatch("aa", "a*")); // true
		System.out.println(test.isMatch("aa", ".*")); // true
		System.out.println(test.isMatch("ab", ".*")); // true
		System.out.println(test.isMatch("aab", "c*a*b")); // true
		System.out.println(test.isMatch("aaa", "aaaa")); // false
		System.out.println(test.isMatch("ab", ".*c")); // false
	}

}
