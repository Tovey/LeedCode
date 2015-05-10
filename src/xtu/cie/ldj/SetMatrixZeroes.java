package xtu.cie.ldj;

public class SetMatrixZeroes {
	/**
	 * space O(1)
	 */
	public void setZeroes_2(int[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0)
			return;
		int m = matrix.length;
		int n = matrix[0].length;
		boolean row_has_zero = false;
		boolean col_has_zero = false;
		int i, j;
		for (i = 0; i < m; i++) {
			if (matrix[i][0] == 0) {
				col_has_zero = true;
				break;
			}
		}
		for (i = 0; i < n; i++) {
			if (matrix[0][i] == 0) {
				row_has_zero = true;
				break;
			}
		}

		for (i = 1; i < m; i++) {
			for (j = 1; j < n; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		for (i = 1; i < m; i++) {
			for (j = 1; j < n; j++) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
		}

		if (col_has_zero) {
			for (i = 0; i < m; i++) {
				matrix[i][0] = 0;
			}
		}
		if (row_has_zero) {
			for (i = 0; i < n; i++) {
				matrix[0][i] = 0;
			}
		}
	}

	/**
	 * space O(m+n)
	 */
	public void setZeroes(int[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0)
			return;
		boolean[] boolR = new boolean[matrix.length];
		boolean[] boolC = new boolean[matrix[0].length];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 0) {
					boolR[i] = true;
					boolC[j] = true;
				}
			}
		}

		for (int i = 0; i < boolR.length; i++) {
			if (boolR[i]) {
				for (int j = 0; j < matrix[i].length; j++) {
					matrix[i][j] = 0;
				}
			}
		}
		for (int i = 0; i < boolC.length; i++) {
			if (boolC[i]) {
				for (int j = 0; j < matrix.length; j++) {
					matrix[j][i] = 0;
				}
			}
		}
	}
}
