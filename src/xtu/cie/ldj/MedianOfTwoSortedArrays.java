package xtu.cie.ldj;

public class MedianOfTwoSortedArrays {
    public static double findMedianSortedArrays(int A[], int B[]) {
    	int[] AB = new int[A.length + B.length];
    	int i_A = 0;
    	int i_B = 0;
    	int i_AB = 0;
    	
    	while(i_A < A.length && i_B < B.length){
    		if(A[i_A] < B[i_B]){
    			AB[i_AB++] = A[i_A++];
    		}else {
    			AB[i_AB++] = B[i_B++];
			}
    	}
    	
    	while(i_A < A.length){
    		AB[i_AB++] = A[i_A++];
    	}
        
    	while(i_B < B.length){
    		AB[i_AB++] = B[i_B++];
    	}
        
    	if(AB.length % 2 == 0)
    		return (double)(AB[AB.length / 2 - 1] + AB[AB.length / 2]) / (double)2.0;
    	else return AB[AB.length / 2];
    }
	
    public static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ",");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = new int[]{1,2,3,4,5,6};
		int[] B = new int[]{};
		
		System.out.println(findMedianSortedArrays(A,B));
	}

}
