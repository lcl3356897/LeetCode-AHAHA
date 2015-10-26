public class Solution {
    public void gameOfLife(int[][] board) {
    	int m = board.length, n = m == 0 ? 0 : board[0].length;
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    	for(int i=0;i<m;i++){
    		for(int j=0;j<n;j++){
    			int count = 0;
    			for(int k =0;k<8;k++){
    				int x = i + dx[k], y = j + dy[k];
    				if(x >= 0 && x < m && y >= 0 && y < n &&(board[x][y] == 1 || board[x][y] == 2)){
    					count++;
    				}
    			}
    			if(board[i][j] == 1 && (count < 2 || count > 3)) board[i][j] = 2;
    			else if(board[i][j] == 0 && count == 3) board[i][j] = 3;
    		}
    	}
    	for(int i=0;i<m;i++){
    		for(int j=0;j<n;j++){
    			board[i][j] %= 2;
    		}
    	}
    }
}