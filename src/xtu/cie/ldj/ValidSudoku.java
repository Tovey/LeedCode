package xtu.cie.ldj;

public class ValidSudoku {
	public boolean isValidSudoku_1(char[][] board) {
		final int SIZE = 9;
		int row;
		int[] col = new int[SIZE];
		int[] box = new int[SIZE];

		for (int i = 0; i < SIZE; i++) {
			row = 0;
			for (int j = 0; j < SIZE; j++) {
				if (board[i][j] == '.')
					continue;

				int bit = 1 << (board[i][j] - '1');
				int box_index = i / 3 * 3 + j / 3;
				if ((row & bit) != 0 || (col[j] & bit) != 0
						|| (box[box_index] & bit) != 0) {
					return false;
				}
				row |= bit;
				col[j] |= bit;
				box[box_index] |= bit;
			}
		}

		return true;
	}

	public boolean isValidSudoku(char[][] board) {
		final int SIZE = 9;
		final int SMALL_SIZE = 3;
		boolean[] used = new boolean[SIZE];

		for (int i = 0; i < SIZE; i++) {
			fillFalse(used);
			// check row
			for (int j = 0; j < SIZE; j++) {
				if (!check(board[i][j], used))
					return false;
			}
			fillFalse(used);
			// check column
			for (int j = 0; j < SIZE; j++) {
				if (!check(board[j][i], used))
					return false;
			}
		}

		// check small board
		for (int r = 0; r < SMALL_SIZE; r++) {
			for (int c = 0; c < SMALL_SIZE; c++) {
				fillFalse(used);

				for (int i = r * 3; i < r * 3 + 3; i++) {
					for (int j = c * 3; j < c * 3 + 3; j++) {
						if (!check(board[i][j], used))
							return false;
					}
				}
			}
		}

		return true;
	}

	private void fillFalse(boolean[] used) {
		for (int i = 0; i < used.length; i++) {
			used[i] = false;
		}
	}

	private boolean check(char ch, boolean[] used) {
		if (ch == '.')
			return true;
		if (used[ch - '1'])
			return false;
		used[ch - '1'] = true;
		return true;
	}
}
