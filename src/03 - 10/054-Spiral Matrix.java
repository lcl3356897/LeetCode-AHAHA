public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
    	List<Integer> rst = new ArrayList<Integer>();
    	if(matrix == null || matrix.length == 0){
    		return rst;
    	}
    	int[] pos = {0, -1};
    	int time=0;
    	boolean[][] visited = new boolean[matrix.length][matrix[0].length];
    	while(rst.size() != matrix.length*matrix[0].length){
    		pos[1] += 1;
    		pos = read(matrix, rst, pos, 0, 1, visited);
    		pos[0] += 1;
    		pos = read(matrix, rst, pos, 1, 0, visited);
    		pos[1] -= 1;
    		pos = read(matrix, rst, pos, 0, -1, visited);
    		pos[0] -= 1;
    		pos = read(matrix, rst, pos, -1, 0, visited);
    	}
    	return rst;
    }

    public int[] read(int[][] matrix, List<Integer> rst, int[] pos, int xdirect, int ydirect, boolean[][] visited){
    	int x = pos[0], y = pos[1];
    	while(x<matrix.length && x>=0 && y<matrix[0].length && y>=0 && visited[x][y] == false){
    		rst.add(matrix[x][y]);
    		visited[x][y] = true;
    		x+=xdirect;
    		y+=ydirect;
    	}
    	pos[0] = x - xdirect; pos[1] = y - ydirect;
    	return pos; 
    }
}

//Level！！
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> rst = new ArrayList<Integer>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
        	return rst;
        }
        int level = (Math.min(matrix.length, matrix[0].length) + 1) / 2;
        for(int i=0;i<level;i++){
        	int lastrow = matrix.length - 1 - i;
        	int lastcolumn = matrix[0].length - 1 - i;
        	if(i == lastrow){//Last Row
        		for(int j=i;j<=lastcolumn;j++){
        			rst.add(matrix[i][j]);
        		}
        	}
        	else if(i == lastcolumn){
        		for(int j=i;j<=lastrow;j++){
        			rst.add(matrix[j][i]);
        		}
        	}
        	else{
        		for(int j=i;j<lastcolumn;j++){
        			rst.add(matrix[i][j]);
        		}
        		for(int j=i;j<lastrow;j++){
        			rst.add(matrix[j][lastcolumn]);
        		}
        		for(int j=lastcolumn;j>i;j--){
        			rst.add(matrix[lastrow][j]);
        		}
        		for(int j=lastrow;j>i;j--){
        			rst.add(matrix[j][i]);
        		}
        	}
        }
        
        return rst;
    }
}
