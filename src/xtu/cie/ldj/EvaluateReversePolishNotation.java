package xtu.cie.ldj;

import java.util.Stack;

public class EvaluateReversePolishNotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] tokens = new String[]{"4", "13", "5", "/", "+"};
		System.out.println(evalRPN(tokens));
	}
	
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stackRPN = new Stack<Integer>();
        for(int i = 0; i < tokens.length; i++){
        	int t1,t2;
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
}
