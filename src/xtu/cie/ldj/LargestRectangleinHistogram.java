package xtu.cie.ldj;

import java.util.Stack;

public class LargestRectangleinHistogram {
	public int largestRectangleArea(int[] height) {
		Stack<Integer> stack = new Stack<Integer>();
		int maxArea = 0;
		
		for (int i = 0; i <= height.length;i++) {
			int h = (i == height.length) ? 0 : height[i];
			
			if (stack.isEmpty() || h > height[stack.peek()]) {
				stack.push(i);
			} else {
				int tmp = stack.pop();
				maxArea = Math.max(maxArea, height[tmp]
						* (stack.empty() ? i : i - stack.peek() - 1));
				i --;
			}
		}
		return maxArea;
	}
}
