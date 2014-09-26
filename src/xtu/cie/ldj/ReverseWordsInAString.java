package xtu.cie.ldj;

public class ReverseWordsInAString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverseWords(" 1"));
	}
	
    public static String reverseWords(String s) {
        String[] subStrings = s.split(" ");
        String resultStr = "";
        for (int i = subStrings.length - 1; i >= 0; i--){
            resultStr +=subStrings[i];
            if(i != 0 && !subStrings[i-1].equals(""))
                resultStr += " ";
        }
        return resultStr;
    }
}
