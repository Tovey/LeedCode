package xtu.cie.ldj;

public class LongestSubstringWithoutRepeatingCharacters {

	public static int lengthOfLongestSubstring(String s) {
		if(s.length() <= 1)		return s.length();
        
		int length = 0;
        String subStr = "";
        for (int i = 0; i < s.length(); i++) {
			if(subStr.contains(String.valueOf(s.charAt(i)))){
				int index = subStr.indexOf(s.charAt(i)) + 1;
				subStr = subStr.substring(index) + String.valueOf(s.charAt(i));
			}else {
				subStr += String.valueOf(s.charAt(i));
				if(subStr.length() > length){
					length = subStr.length();
				}
			}
		}
        
        return length;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str0 = "bbbb";
		String str1 = "abcabcbb";
		String str2 = "hnwnkuewhsqmgbbuqcljjivswmdkqtbxixmvtrrbljptnsnfwzqfjmafadrrwsofsbcnuvqhffbsaqxwpqcac";
		String str3 = "wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco";
		String str4 = "qopubjguxhxdipfzwswybgfylqvjzhar";
		
		System.out.println("str0 : 1 --> " + lengthOfLongestSubstring(str0));
		System.out.println("str1 : 3 --> " + lengthOfLongestSubstring(str1));
		System.out.println("str2 : 12 --> " + lengthOfLongestSubstring(str2));
		System.out.println("str3 : 12 --> " + lengthOfLongestSubstring(str3));
		System.out.println("str4 : 12 --> " + lengthOfLongestSubstring(str4));
	}

}
