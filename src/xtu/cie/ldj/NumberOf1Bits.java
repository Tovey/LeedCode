package xtu.cie.ldj;

public class NumberOf1Bits {
	//Accepted:209ms
	public int hammingWeight(int n){
		int count ;
		for(count = 0; n != 0; count ++){
			n &= (n - 1);
		}
		return count;
	}

	public static void main(String[] args) {
		NumberOf1Bits numberOf1Bits = new NumberOf1Bits();
		
		System.out.println(numberOf1Bits.hammingWeight(0));
		System.out.println(numberOf1Bits.hammingWeight(1));
		System.out.println(numberOf1Bits.hammingWeight(11));
		System.out.println(numberOf1Bits.hammingWeight(10));
	}

}
