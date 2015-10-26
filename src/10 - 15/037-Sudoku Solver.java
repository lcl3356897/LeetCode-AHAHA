public class Solution {
    public void solveSudoku(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0){
            return;
        }
        solve(board);
    }
    
    private boolean solve(char[][]board){
    	for(int i=0;i<board.length;i++){
    		for(int j=0;j<board[i].length;j++){
    			if(board[i][j] == '.'){
    				for(char c='1';c<='9';c++){
    					if(valid(board, i, j, c)){
    						board[i][j] = c;
        					if(solve(board)){
        						return true;
        					}
        					else{
        						board[i][j] = '.';
        					}
    				    }
    				}
    				//no good choice
    				return false;
    			}
    		}
    	}
    	return true;
    }
    
    private boolean valid(char[][] board, int row, int col, char c){
    	for(int i=0;i<9;i++){//check column
    		if(board[i][col] == c){
    			return false;
    		}
    	}
    	for(int j=0;j<9;j++){//check row
    		if(board[row][j] == c){
    			return false;
    		}
    	}
    	for(int i=row/3*3;i<row/3*3+3;i++){
    		for(int j=col/3*3;j<col/3*3+3;j++){
    			if(board[i][j] == c){
    				return false;
    			}
    		}
    	}
    	return true;
    }
}