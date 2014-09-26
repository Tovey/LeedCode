package xtu.cie.ldj;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class WordBreak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> dict = new HashSet<String>();
		dict.add("aaaa");
		dict.add("aaa");
		System.out.println(wordBreak("aaaaaaa", dict));
	}

	public static boolean wordBreak(String s, Set<String> dict) {
		if (s.length() == 0 || dict.isEmpty())
			return false;
		if (dict.contains(s))	return true;
		
		int i = 0, j = 0;
		while (i < s.length() && j < s.length()) {
			System.out.println("i = " + i + "\tj = " + j + "\t" + s.substring(i, j + 1));
			if (dict.contains(s.substring(i, j + 1))) {
				i = j + 1;
				j++;
			} else {
				j++;
			}
		}
		
		if (i == s.length())
			return true;
		else
			return false;
	}
}
