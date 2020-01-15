package pckg_dflt;

public class FindBattleships {

	public static void main(String[] args) {
		
		char[][] board = new char[][] {{'X','.','.','X'},
									   {'.','.','.','X'},
									   {'.','.','.','X'}};

		int out = new FindBattleships().countBattleships(board);
		System.out.println(out);
			
	}
		

	
    public int countBattleships(char[][] board) {
        
        if (board == null || board.length == 0 || board[0].length == 0){
            return 0;
        }
        
        int lastRow = board.length;
        int lastCol = board[0].length;
        int count = 0;
        
        
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[0].length; col++){
                
                //if I encounter a ship
                if (board[row][col] == 'X'){
                    
                    //if ships are horizontal, column-1 should have an 'X' and column+1 should not have an 'X'
                    if (isEndHorizontal(board, row, col) && isEndVertical(board, row, col))
                    	count++;
                } 
            }
        }
        
        return count;
        
    }
    
    public static boolean isEndHorizontal(char[][]board, int row, int column){
        
        if (column >= 0 && column+1<board[0].length){
            //there exists a next column, holds an X
            if (board[row][column+1] == 'X' )
                return false;
            //there exists a next column, holds a space
            else
                return true;
        } else{
            //there is no next column
            return true;
        }
    }
    
    public static boolean isEndVertical(char[][]board, int row, int column){
       
        if (row >= 0 && row+1<board.length){
            //there exists a next row, holds an X
            if (board[row+1][column] == 'X' )
                return false;
            //there exists a next row, holds a space
            else
                return true;
        } else{
            //there is no next row
            return true;
        }        
        
    }
	
}
