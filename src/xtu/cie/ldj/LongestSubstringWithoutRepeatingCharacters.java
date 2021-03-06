package xtu.cie.ldj;

public class LongestSubstringWithoutRepeatingCharacters {
	// Accepted:500ms
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
	
	// Accepted:274ms
	public static int lengthOfLongestSubstring2(String s) {
		if (s.length() <= 1)	return s.length();
		int start = 0, end = 0;
		int length = 0;
		int index;
		
		for (int i = 0; i < s.length(); i++) {
			index = findCharPosInString(s, start, end, s.charAt(i));
			if(index >= 0){ // 已经存在
				start = index + 1;
				end ++;
			}else {
				end ++;
				if(end - start > length){
					length = end - start;
				}
			}
		}
		
		return length;
	}
	
	public static int findCharPosInString(String str,int s,int e,char ch){
		for (int i = s; i < e; i++) {
			if (str.charAt(i) == ch) {
				return i;
			}
		}
		return -1;
	}
	
	// Accepted:244ms
	public static int lengthOfLongestSubstring3(String s) {
		if (s.length() <= 1)	return s.length();
		int start = 0, end = 0;
		int length = 0;
		int index;
		int[] array = new int[256];
		
		for (int i = 0; i < s.length(); i++) {
			index = array[s.charAt(i)];
			array[s.charAt(i)] = i + 1;
			
			if(index > start){ // 已经存在
				start = index;
				end ++;
			}else{
				end ++;
				if(end - start > length){
					length = end - start;
				}
			}
		}
		
		return length;
	}
	
	public static void main(String[] args) {
		String str0 = "bbbb";
		String str1 = "abcabcbb";
		String str2 = "hnwnkuewhsqmgbbuqcljjivswmdkqtbxixmvtrrbljptnsnfwzqfjmafadrrwsofsbcnuvqhffbsaqxwpqcac";
		String str3 = "wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco";
		String str4 = "qopubjguxhxdipfzwswybgfylqvjzhar";
		String str5 = "au";
		
		System.out.println("str0 : 1 --> " + lengthOfLongestSubstring3(str0));
		System.out.println("str1 : 3 --> " + lengthOfLongestSubstring3(str1));
		System.out.println("str2 : 12 --> " + lengthOfLongestSubstring3(str2));
		System.out.println("str3 : 12 --> " + lengthOfLongestSubstring3(str3));
		System.out.println("str4 : 12 --> " + lengthOfLongestSubstring3(str4));
		System.out.println("str5 : 2 --> " + lengthOfLongestSubstring3(str5));
		
	}

}
