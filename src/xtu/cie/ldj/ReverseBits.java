package xtu.cie.ldj;

public class ReverseBits {
	//Accepted:269ms
	public int reverseBits(int n) {
		int y = 0;
		int t;
		for(int i = 0; i < 32; i++){
			t = n & 1;
			n >>= 1;
			y <<= 1;
			y |= t;
		}
		return y;
	}

	public static void main(String[] args) {
		ReverseBits reverseBits = new ReverseBits();
		System.out.println(reverseBits.reverseBits(43261596) + "");
	}

}
