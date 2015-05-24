package xtu.cie.ldj;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Anagrams {
	private int[] chars= new int[30];
	
	private String getStringOfAnagram(String str){
		for (int i = 0; i < chars.length; i++) {
			chars[i] = 0;
		}
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if(ch >= 'a' && ch <= 'z'){
				chars[ch - 'a'] ++;
			}
		}
		StringBuilder sBuilder = new StringBuilder();
		for (int i = 0; i < chars.length; i++) {
			for (int j = 0; j < chars[i]; j++) {
				sBuilder.append((char)(i + 'a'));
			}
		}
		return sBuilder.toString();
	}
	
    public List<String> anagrams(String[] strs) {
        LinkedList<String> list = new LinkedList<String>();
        HashMap<String, LinkedList<Integer>> hashMap = new HashMap<String, LinkedList<Integer>>();
        for(int i = 0; i < strs.length;i++){
        	String str = getStringOfAnagram(strs[i]);
        	if(hashMap.containsKey(str)){
        		hashMap.get(str).add(i);
        	}else {
				LinkedList<Integer> tmpList = new LinkedList<Integer>();
				tmpList.add(i);
				hashMap.put(str, tmpList);
			}
        }
        
        for (String key : hashMap.keySet()) {
        	if(hashMap.get(key).size() > 1){
        		LinkedList<Integer> tmpList = hashMap.get(key);
        		for (int ind : tmpList) {
        			list.add(strs[ind]);
				}
        	}
		}
        return list;
    }
    
    public static void main(String[] args) {
    	Anagrams anagrams = new Anagrams();
    	System.out.println(anagrams.getStringOfAnagram("abcabc"));
	}
}
