package xtu.cie.ldj;

public class RotateImage {
	public static void rotate_2(int[][] matrix){
		final int N = matrix.length;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - i; j++) {
				swap(matrix, i, j, N - 1 - j, N - 1 - i);
			}
		}
		
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < N; j++) {
				swap(matrix, i, j, N - 1 - i, j);
			}
		}
	}
	
	private static void swap(int[][] matrix,int i,int j,int p,int q){
		int temp = matrix[i][j];
		matrix[i][j] = matrix[p][q];
		matrix[p][q] = temp;
	}
	
	
	public static void rotate(int[][] matrix) {
		final int N = matrix.length;
		for (int i = 0; i < N / 2; i++) {
			swap(matrix, i);
		}
	}
	
	private static void swap(int[][] matrix,int x){
		final int N = matrix.length;
		for (int i = x; i < N - 1 - x; i++) {
			int t = matrix[N - 1 - i][x];
			matrix[N - 1 - i][x] = matrix[N - 1 - x][N - 1 - i];
			matrix[N - 1 - x][N - 1 - i] = matrix[i][N - 1 - x];
			matrix[i][N - 1 - x] = matrix[x][i];
			matrix[x][i] = t;
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 1, 2, 3, 4 }, { 1, 2, 3, 4 },
				{ 1, 2, 3, 4 } };
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println("\n");
		
		rotate_2(matrix);
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
