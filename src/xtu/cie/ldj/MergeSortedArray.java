package xtu.cie.ldj;

public class MergeSortedArray {
	/**
	 * Accepted: 218ms
	 * A has enough space (size of A is greater or equal m+n)
	 */
    public void merge(int A[], int m, int B[], int n) {
        int last = m + n - 1;
        int i = m - 1,j = n - 1;
        while(i >= 0 && j >= 0){
        	if(A[i] >= B[j]){
        		A[last] = A[i --];
        	}else{
        		A[last] = B[j --];
        	}
        	last --;
        }
        
        if(j >= 0){
        	while(j >= 0)
        		A[last --] = B[j --];
        }
    }
}
