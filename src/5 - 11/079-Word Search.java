public class Solution {
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || board[0].length == 0 || word == null){
        	return false;
        }
        if(word.length() == 0){
        	return true;
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
        	for(int j=0;j<board[0].length;j++){
        		if(helper(board, word, 0, i, j, visited)){
        			return true;
        		}
        	}
        }
        return false;
    }
    public boolean helper(char[][] board, String word, int index, int x, int y, boolean[][] visited){
    	if(index == word.length()){
    		return true;
    	}
    	if(x < 0 || x > board.length - 1 || y < 0 || y > board[0].length - 1 || visited[x][y] == true){
    		return false;
    	}
    	if(board[x][y] == word.charAt(index)){
    		visited[x][y] = true;
    		if(helper(board, word, index+1, x+1, y, visited) || helper(board, word, index+1, x-1, y, visited) || helper(board, word, index+1, x, y+1, visited) || helper(board, word, index+1, x, y-1, visited)){
    			return true;
    		}
    		else{
    			visited[x][y] = false;
    			return false;
    		}
    	}
    	return false;
    }
}