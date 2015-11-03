public class Solution {
    public void solveSudoku(char[][] board) {
        if(board == null || board.length != 9) return;
        solve(board);
    }

    private boolean solve(char[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] != '.') continue;
                for(char c = '1'; c <= '9'; c++){
                    if(valid(board, i, j, c)){
                        board[i][j] = c;
                        if(solve(board)){
                            return true;
                        }
                        board[i][j] = '.';
                    }
                }
                return false;
            }
        }
        return true;
    }

    private boolean valid(char[][] board, int x, int y, char c){
        for(int i = 0; i < board.length; i++){
            if(board[i][y] == c) return false;
        }

        for(int j = 0; j < board[x].length; j++){
            if(board[x][j] == c) return false;
        }

        for(int i = x / 3 * 3; i < x / 3 * 3 + 3; i++){
            for(int j = y / 3 * 3; j < y / 3 * 3 + 3; j++){
                if(board[i][j] == c) return false;
            }
        }

        return true;
    }
}