package xtu.cie.ldj;

public class ValidNumber {
	public boolean isNumber(String s) {
		if (s == null || s.length() == 0)
			return false;
		
		s = s.trim();
		boolean hasPoint = false;
		boolean hasE = false;
		boolean hasNum = false;
		boolean hasNumAfterE = true;
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if('0' <= ch && ch <= '9'){
				hasNum = true;
				hasNumAfterE = true;
			}else if (ch == '.') {
				if (hasE || hasPoint) {
					return false;
				}
				hasPoint = true;
			}else if (ch == 'e') {
				if (hasE || !hasNum) {
					return false;
				}
				hasNumAfterE = false;
				hasE = true;
			}else if (ch == '-' || ch == '+') {
				if(i != 0 && s.charAt(i - 1) != 'e'){
					return false;
				}
			}else {
				return false;
			}
		}

		return hasNum && hasNumAfterE;
	}
}
