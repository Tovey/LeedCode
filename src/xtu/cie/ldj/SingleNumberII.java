package xtu.cie.ldj;

public class SingleNumberII {
	/**
	 * Accepted: 378ms
	 */
    public int singleNumber_1(int[] A) {
    	int[] c = new int[32];
        for (int i = 0; i < c.length; i++) {
        	int t = 1 << i;
			for (int j = 0; j < A.length; j++) {
				if((A[j] & t) != 0)
					c[i] += 1;
			}
			c[i] %= 3;
		}
        int res = 0;
        for (int i = c.length - 1; i >= 0; i--) {
        	res <<= 1;
        	res += c[i];
        }
        return res;
    }
    /**
	 * Accepted: 360ms
	 */
    public int singleNumber_2(int[] A) {
    	int one = 0,two = 0,three = 0;
    	for(int i = 0; i < A.length; i++){
    		two |= (one & A[i]);  // ���ֹ�2�ε�λ��Ϊ1
    		one ^= A[i];		  // ���ֹ�1�ε�λ��Ϊ1
    		three = one & two;    // ���ֹ�3�ε�λ��Ϊ1
    		one &= ~three;
    		two &= ~three;        // ������ֹ�3�ε�λ��
    	}
    	return one;
    }
}
