package xtu.cie.ldj;

public class RemoveDuplicatesfromSortedArrayII {
	/**
	 * Accepted:298ms
	 */
	public int removeDuplicates(int[] A) {
		if(A.length <= 2)
			return A.length;
		int c = 0;
		boolean flag = false;
		if(A[1] == A[0])
			flag = true;
		
		for(int i = 1; i < A.length; i++){
			if(A[i] != A[c]){
				A[++c] = A[i];
				flag = true;
			}else {
				if(flag){
					A[++c] = A[i];
				}
				flag = false;
			}
		}
		
		return c+1;
	}
}
