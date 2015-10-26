public class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0){
            return false;
        }
        for(int i=0;i<board.length;i++){
            if(!row(board, i)){
                return false;
            }
        }

        for(int j=0;j<board[0].length;j++){
            if(!col(board, j)){
                return false;
            }
        }

        return cell(board, 0, 0) && cell(board, 0, 3) && cell(board, 0, 6)
            && cell(board, 3, 0) && cell(board, 3, 3) && cell(board, 3, 6)
            && cell(board, 6, 0) && cell(board, 6, 3) && cell(board, 6, 6);
    }

    public boolean row(char[][] board, int row){
        boolean[] used = new boolean[10];
        for(int j=0;j<board[row].length;j++){
            if(board[row][j] == '.'){
                continue;
            }
            if(used[ board[row][j] - '0' ] == true){
                return false;
            }
            used[ board[row][j] - '0' ] = true;
        }
        return true;
    }

    public boolean col(char[][] board, int col){
        boolean[] used = new boolean[10];
        for(int i=0;i<board.length;i++){
            if(board[i][col] == '.'){
                continue;
            }
            if(used[ board[i][col] - '0' ] == true){
                return false;
            }
            used[ board[i][col] - '0' ] = true;
        }
        return true;
    }

    public boolean cell(char[][] board, int rstart, int cstart){
        boolean[] used = new boolean[10];
        for(int i=rstart;i<rstart+3;i++){
            for(int j=cstart;j<cstart+3;j++){
                if(board[i][j] == '.'){
                    continue;
                }
                if(used[ board[i][j] - '0' ] == true){
                    return false;
                }
                used[ board[i][j] - '0' ] = true;
            }
        }
        return true;
    }
}