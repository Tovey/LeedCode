package xtu.cie.ldj;

import java.util.ArrayList;
import java.util.Stack;

public class EvaluateReversePolishNotation {
	//Accepted:362ms
	public static int evalRPN_2(String[] tokens) {
		int[] stack = new int[tokens.length];
		int top = 0;
		int t1, t2;
		for (int i = 0; i < tokens.length; i++) {
			if (tokens[i].length() == 1) {
				switch (tokens[i].charAt(0)) {
				case '+':
					t1 = stack[--top];
					t2 = stack[--top];
					stack[top++] = t2 + t1;
					break;
				case '-':
					t1 = stack[--top];
					t2 = stack[--top];
					stack[top++] = t2 - t1;
					break;
				case '*':
					t1 = stack[--top];
					t2 = stack[--top];
					stack[top++] = t2 * t1;
					break;
				case '/':
					t1 = stack[--top];
					t2 = stack[--top];
					stack[top++] = t2 / t1;
					break;
				default:
					stack[top++] = Integer.parseInt(tokens[i]);
					break;
				}
			}else{
				stack[top++] = Integer.parseInt(tokens[i]);
			}
		}

		return stack[0];
	}

	// Accepted:504ms
	public static int evalRPN_1(String[] tokens) {
		Stack<Integer> stackRPN = new Stack<Integer>();
		for (int i = 0; i < tokens.length; i++) {
			int t1, t2;
			switch (tokens[i]) {
			case "+":
				t1 = stackRPN.pop();
				t2 = stackRPN.pop();
				stackRPN.push(t2 + t1);
				break;
			case "-":
				t1 = stackRPN.pop();
				t2 = stackRPN.pop();
				stackRPN.push(t2 - t1);
				break;
			case "*":
				t1 = stackRPN.pop();
				t2 = stackRPN.pop();
				stackRPN.push(t2 * t1);
				break;
			case "/":
				t1 = stackRPN.pop();
				t2 = stackRPN.pop();
				stackRPN.push(t2 / t1);
				break;
			default:
				stackRPN.push(Integer.parseInt(tokens[i]));
				break;
			}
		}
		return stackRPN.pop();
	}

	public static void main(String[] args) {
		String[] tokens = new String[] { "4", "13", "5", "/", "+" };
		System.out.println(evalRPN_2(tokens));
	}
}
