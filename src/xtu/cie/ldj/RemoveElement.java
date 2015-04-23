package xtu.cie.ldj;

public class RemoveElement {
	//Accepted: 230ms
	public int removeElement(int[] A, int elem) {
        int len = A.length;
        if(len == 0) return 0;
        
        int i = 0;
        for(int j = 0; j < len;j++){
            if(A[j] != elem){
                A[i] = A[j];
                i = i + 1;
            }
        }
        
        return i;
    }
}
