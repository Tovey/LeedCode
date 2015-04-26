package xtu.cie.ldj;

public class SearchA2DMatrix {
	/**
	 * Accepted:252ms
	 */
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix.length == 0)
			return false;

		int c = matrix.length - 1;
		for (int i = 0; i < matrix.length - 1; i++) {
			if (matrix[i][0] <= target && matrix[i + 1][0] > target) {
				c = i;
				break;
			}
		}
		for (int j = 0; j < matrix[c].length; j++) {
			if (matrix[c][j] == target)
				return true;
		}

		return false;
	}

	/**
	 * Accepted:306ms
	 */
	public boolean searchMatrix_2(int[][] matrix, int target) {
		if (matrix.length == 0)
			return false;

		int c = matrix.length - 1;
		for (int i = 0; i < matrix.length - 1; i++) {
			if (matrix[i][0] <= target && matrix[i + 1][0] > target) {
				c = i;
				break;
			}
		}

		int l = 0, r = matrix[c].length - 1;
		while (l <= r) {
			int m = (l + r) / 2;
			if (matrix[c][m] == target)
				return true;
			else if (matrix[c][m] > target)
				r = m - 1;
			else
				l = m + 1;
		}

		return false;
	}
}
