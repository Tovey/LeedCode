package xtu.cie.ldj;

public class PermutationSequence {
	/**
	 * http://blog.csdn.net/abcjennifer/article/details/40152323
	 */
	public String getPermutation(int n, int k) {
		StringBuffer sb = new StringBuffer();
		int sum = 1;
		for (int i = 2; i < n; i++) {
			sum *= i;
		}
		boolean[] isVisited = new boolean[n + 2];
		for (int i = 1; i < n && k != 0; i++) {
			int nextIndex = k / sum;
			k %= sum;
			if (k == 0) {
				nextIndex --;
			}
			sum /= (n - i);
			int count = 0;
			for (int j = 0; j < n; j++) {
				if (!isVisited[j]) {
					if (count == nextIndex) {
						isVisited[j] = true;
						sb.append(j + 1);
						break;
					}
					count ++;
				}
			}
		}
		for (int j = n - 1; j >= 0; j--) {
			if(!isVisited[j])
				sb.append(j + 1);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		PermutationSequence ps = new PermutationSequence();
		System.out.println(ps.getPermutation(3, 2));
	}
}
