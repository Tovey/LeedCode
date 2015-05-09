package xtu.cie.ldj;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
	/**
	 * binary b to gray code r:
	 * 		r = b ^ (b >> 1)
	 * gray code r to binary b: (n bit)
	 * 		b = r & (1 << n - 1);
	 * 		for (int j = n - 1; j >= 0; j--){
	 * 			b |= ((b >> 1) ^ t) & (1 << j);
	 * 		}
	 */
	public List<Integer> grayCode(int n) {
		final int N = 1 << n;
		List<Integer> listGrayCode = new ArrayList<Integer>(N);
		for (int i = 0; i < N; i++) {
			// binary to gray code
			 listGrayCode.add(i ^ (i >> 1));
		}
		return listGrayCode;
	}

	public static void main(String[] args) {
		GrayCode grayCode = new GrayCode();
		grayCode.grayCode(4);
	}
}
