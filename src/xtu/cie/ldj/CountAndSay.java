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
	
	public String countAndSay_2(int n) {
		StringBuilder result = new StringBuilder("1");
		for (int i = 1; i < n; i++) {
			StringBuilder pre = result;
			result = new StringBuilder();
			int j = 0;
			while (j < pre.length()) {
				char ch = pre.charAt(j ++);
				int count = 1;
				while (j < pre.length() && pre.charAt(j) == ch) {
					count ++;
					j++;
				}
				result.append(count);
				result.append(ch);
			}
		}
		return result.toString();
	}
	
	public static void main(String[] args) {
		CountAndSay countAndSay = new CountAndSay();
		System.out.println(countAndSay.countAndSay_2(4));

		
	}
}
