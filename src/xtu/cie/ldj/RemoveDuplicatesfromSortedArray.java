package xtu.cie.ldj;

public class RemoveDuplicatesfromSortedArray {
	/**
	 * Accepted:275ms
	 */
	public int removeDuplicates(int[] A) {
		if(A.length <= 1)
			return A.length;
		int c = 0;
		for(int i = 1; i < A.length; i++){
			if(A[i] != A[c]){
				A[++c] = A[i];
			}
		}
		return c+1;
	}
}
