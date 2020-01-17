package pckg_dflt;

public class SurroundedRegions {

	public static void main(String[] args) {

		char board[][] = new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
		SurroundedRegions s1 = new SurroundedRegions( );
		s1.print(board);
		System.out.println("-------------------");
		s1.solve(board);
		s1.print(board);
	}
	
	private void print(char[][] board) {
		
		for(int r=0; r<board.length; r++) {
			for(int c=0; c<board[r].length; c++) {
				System.out.print(board[r][c] + "\t");
			}
			System.out.println();
		}
	}

	public void solve(char[][] board) {
		if (board == null || board.length == 0)
			return;

		int nr = board.length, nc = board[0].length;
		for (int r = 0; r < nr; r++) {
			for (int c = 0; c < nc; c++) {
				if (board[r][c] == 'O') {
					// if board[r][c] is border attached
					if (!isBorderAttached(board, r, c))
						// to mark the whole region by 'X'
						flip(board, r, c, 'X');
					// if board[r][c] is not border attached
					else
						// to mark the whole region by 'O'
						flip(board, r, c, 'O');
				}
			}
		}
	}

	public void flip(char[][] board, int row, int column, char marker) {

		int nr = board.length, nc = board[0].length;
		if (row < 0 || column < 0 || row >= nr || column >= nc || board[row][column] != 'Q')
			return;

		board[row][column] = marker;
		flip(board, row - 1, column, marker);
		flip(board, row + 1, column, marker);
		flip(board, row, column - 1, marker);
		flip(board, row, column + 1, marker);

	}

	public boolean isBorderAttached(char[][] board, int row, int column) {

		if (board[row][column] == 'Q') {
			//this has already been visited, so return false
			return false;
		}
		
		int boardRows = board.length;
		int columnRows = board[0].length;

		// check we don't collide with borders
		if (row + 1 >= boardRows || column + 1 >= columnRows || row == 0 || column == 0) {
			return true;
		}

		board[row][column] = 'Q';

		return isBorderAttached(board, row - 1, column) || 
			   isBorderAttached(board, row + 1, column) ||				
			   isBorderAttached(board, row, column - 1) || 
			   isBorderAttached(board, row, column + 1);
	}

}
