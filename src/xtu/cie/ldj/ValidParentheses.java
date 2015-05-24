package xtu.cie.ldj;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {
	// 256ms
	public boolean isValid_3(String s) {
		if (s.length() == 0)
			return true;
		if (s.length() % 2 != 0)
			return false;
		HashMap<Character, Character> hashMap = new HashMap<Character, Character>(
				3);
		hashMap.put('(', ')');
		hashMap.put('{', '}');
		hashMap.put('[', ']');
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			if(hashMap.containsKey(s.charAt(i))){
				stack.push(hashMap.get(s.charAt(i)));
			}else {
				if(stack.isEmpty() || s.charAt(i) != stack.pop()){
					return false;
				}
			}
		}

		return stack.isEmpty();
	}

	public boolean isValid_2(String s) {
		if (s.length() == 0)
			return true;
		if (s.length() % 2 != 0)
			return false;

		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == '(' || ch == '[' || ch == '{') {
				stack.push(ch);
			} else if (!stack.isEmpty()) {
				if ((stack.peek() == '(' && ch == ')')
						|| (stack.peek() == '[' && ch == ']')
						|| (stack.peek() == '{' && ch == '}')) {
					stack.pop();
				} else {
					return false;
				}
			} else {
				return false;
			}

		}

		return stack.isEmpty();
	}

	public boolean isValid_1(String s) {
		if (s.length() == 0)
			return true;
		if (s.length() % 2 != 0)
			return false;

		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			if (stack.isEmpty()) {
				stack.push(s.charAt(i));
				continue;
			}

			char ch1 = stack.peek();
			char ch2 = s.charAt(i);

			if ((ch1 == '(' && ch2 == ')') || (ch1 == '[' && ch2 == ']')
					|| (ch1 == '{' && ch2 == '}')) {
				stack.pop();
			} else {
				stack.push(ch2);
			}
		}

		return stack.isEmpty();
	}

	public boolean isValid(String s) {
		if (s.length() == 0)
			return true;
		if (s.length() % 2 != 0)
			return false;

		char[] chs = new char[s.length() + 1];
		int top = 0;

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (top == 0 || ch == '(' || ch == '[' || ch == '{') {
				chs[top] = ch;
				top++;
				continue;
			}
			boolean flag = false;
			switch (ch) {
			case ')':
				if (chs[top - 1] == '(')
					flag = true;
				break;
			case ']':
				if (chs[top - 1] == '[')
					flag = true;
				break;
			case '}':
				if (chs[top - 1] == '{')
					flag = true;
				break;
			}

			if (!flag) {
				return false;
			} else {
				top--;
			}
		}

		return top == 0;
	}

	public static void main(String[] args) {
		ValidParentheses validParentheses = new ValidParentheses();
		System.out.println(validParentheses.isValid_2("(([]))"));
	}
}
