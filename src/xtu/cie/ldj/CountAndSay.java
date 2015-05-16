package xtu.cie.ldj;

import java.util.LinkedList;

public class CountAndSay {
	private LinkedList<String> linkedList = null;

	public String countAndSay(int n) {
		if (linkedList == null){
			linkedList = new LinkedList<String>();
			linkedList.add("1");
		}
		if (n <= linkedList.size()) {
			return linkedList.get(n - 1);
		}
		int index = linkedList.size();
		String preStr = linkedList.get(index - 1);

		for (; index <= n; index++) {
			preStr = getNextSay(preStr);
			linkedList.add(preStr);
		}

		return linkedList.get(n - 1);
	}

	private String getNextSay(String str) {
		StringBuilder sb = new StringBuilder();
		int i = 0;
		while (i < str.length()) {
			char ch = str.charAt(i ++);
			int count = 1;
			while (i < str.length() && str.charAt(i) == ch) {
				count ++;
				i++;
			}
			sb.append(count);
			sb.append(ch);
		}

		return sb.toString();
	}
	
	public static void main(String[] args) {
		CountAndSay countAndSay = new CountAndSay();
		System.out.println(countAndSay.countAndSay(1));
		System.out.println(countAndSay.countAndSay(2));
		System.out.println(countAndSay.countAndSay(3));
		System.out.println(countAndSay.countAndSay(4));
		System.out.println(countAndSay.countAndSay(5));
		System.out.println(countAndSay.countAndSay(6));
		System.out.println(countAndSay.countAndSay(7));
		
	}
}
