public class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int[][] dp = new int[matrix.length][matrix[0].length];
        int rst = 0;
        for(int i=0;i<matrix.length;i++){
            dp[i][0] = matrix[i][0] == '1' ? 1 : 0;
            rst = Math.max(rst, dp[i][0]);
        }
        for(int j=0;j<matrix[0].length;j++){
            dp[0][j] = matrix[0][j] == '1' ? 1 : 0;
            rst = Math.max(rst, dp[0][j]);
        }
        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[i].length;j++){
                dp[i][j] = matrix[i][j] == '0' ? 0 : Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                rst = Math.max(rst, dp[i][j]);
            }
        }
        return rst*rst;
    }
}