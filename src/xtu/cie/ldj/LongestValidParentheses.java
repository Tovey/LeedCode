package xtu.cie.ldj;

import java.util.Stack;

public class LongestValidParentheses {
	public int longestValidParentheses(String s) {
		int maxLen = 0, last = -1; // position of the last ')'
		Stack<Integer> stack = new Stack<Integer>();// position of '('
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push(i);
			} else {// ')'
				if (stack.isEmpty()) {
					last = i;
				} else {
					stack.pop();
					if (stack.isEmpty()) {
						maxLen = Math.max(maxLen, i - last);
					} else {
						maxLen = Math.max(maxLen, i - stack.peek());
					}
				}
			}
		}
		return maxLen;
	}
	
	public int longestValidParentheses_2(String s) {
		int maxLen = 0,depth = 0,start = -1;
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '('){
				depth ++;
			}else {
				depth --;
				if(depth < 0){
					depth = 0;
					start = i;
				}else if(depth == 0){
					maxLen = Math.max(maxLen, i - start);
				}
			}
		}
		depth = 0;
		start = s.length();
		for(int i = s.length() - 1; i >= 0; i--){
			if(s.charAt(i) == ')'){
				depth ++;
			}else {
				depth --;
				if(depth < 0){
					depth = 0;
					start = i;
				}else if(depth == 0){
					maxLen = Math.max(maxLen, start - i);
				}
			}
		}
		
		return maxLen;
	}
}
