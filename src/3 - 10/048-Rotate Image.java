public class Solution {
    public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
        	return;
        }
        int level = matrix.length / 2;
        for(int i=0;i<level;i++){
        	int last = matrix.length - 1 - i;
        	for(int j=0;j<last-i;j++){
            	int tmp = matrix[i][i+j];
            	matrix[i][i+j] = matrix[last-j][i];
            	matrix[last-j][i] = matrix[last][last-j];
            	matrix[last][last-j] = matrix[i+j][last];
            	matrix[i+j][last] = tmp;
        	}
        }
    }
}