public class Solution {
    public int numIslands(char[][] grid) {
    	if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
    	int rst =0;
    	boolean[][] visited = new boolean[grid.length][grid[0].length];
    	for(int i=0;i<grid.length;i++){
    		for(int j=0;j<grid[0].length;j++){
    			if(!visited[i][j] && grid[i][j] == '1'){
    				rst++;
    				helper(i, j, grid, visited);
    			}
    		}
    	}
    	return rst;
    }
    
    private void helper(int row, int col, char[][] grid, boolean[][] visited){
    	if(row < 0 || row >= visited.length || col < 0 || col >= visited[0].length || grid[row][col] == '0'){
    		return;
    	}
    	
    	if(visited[row][col]) return;
    	
    	visited[row][col] = true;
    	
    	helper(row-1, col, grid, visited);
    	helper(row+1, col, grid, visited);
    	helper(row, col-1, grid, visited);
    	helper(row, col+1, grid, visited);
    }
}