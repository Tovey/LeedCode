package xtu.cie.ldj;

public class ClimbingStairs {
	/**
	 * JAVA: Accepted:233ms
	 *   C : Accepted: 1ms
	 * f(0) = 1
	 * f(1) = 1
	 * f(n) = f(n-1) + f(n-2)
	 */
	public int climbStairs(int n) {
		int last = 1;
		int lastlast = 1;
		for (int i = 2; i <= n; i++) {
			int step = last + lastlast;
			lastlast = last;
			last = step;
		}
		
		return last;
	}
}
