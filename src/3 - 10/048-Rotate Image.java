public class Solution {
    public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return;
        int n = matrix.length;
        int level = n / 2;
        for(int i = 0; i < level; i++){
            int last = n - 1 - i;
            for(int j = 0; i + j < last; j++){
                int tmp = matrix[i][i + j];
                matrix[i][i + j] = matrix[last - j][i];
                matrix[last - j][i] = matrix[last][last - j];
                matrix[last][last - j] = matrix[i + j][last];
                matrix[i + j][last] = tmp;
            }
        }
    }
}