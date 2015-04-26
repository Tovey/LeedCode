package xtu.cie.ldj;

public class SortColors {
	/**
	 * Accepted:241ms
	 */
	public void sortColors_2(int[] A) {
		int zero = 0,second = A.length - 1;
		for (int k = 0; k < second; k++) {
			int t;
			while(A[k] == 2 && k < second){
				t = A[k];
				A[k] = A[second];
				A[second--] = t;
			}
			while(A[k] == 0 && k > zero){
				t = A[k];
				A[k] = A[zero];
				A[zero++] = t;
			}
		}
	}
	
	/**
	 * Accepted:247ms
	 */
	public void sortColors(int[] A) {
		if(A == null || A.length <= 1) return;
		int c0 = 0,c1 = 0;
		int i;
		for(i = 0; i < A.length; i++){
			if(A[i] == 0) c0 ++;
			else if(A[i] == 1) c1++;
		}
		c1 += c0;
		for(i = 0; i < c0; i++) A[i] = 0;
		for(i = c0; i < c1; i++) A[i] = 1;
		for(i = c1; i < A.length; i++) A[i] = 2;
	}
}
