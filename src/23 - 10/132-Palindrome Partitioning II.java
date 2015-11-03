public class Solution {
    public int minCut(String s) {
        if(s == null || s.length() == 0) return 0;

        int n = s.length();
        boolean[][] is = new boolean[n][n];
        int[] dp = new int[n + 1];
        for(int i = 0; i <= n; i++){
            dp[i] = n - i;
        }

        for(int i = n - 1; i >= 0; i--){
            for(int j = i; j < n; j++){
                if(( j - i <= 1 || is[i + 1][j - 1]) && s.charAt(i) == s.charAt(j)){
                    is[i][j] = true;
                    dp[i] = Math.min(dp[i], dp[j + 1] + 1);
                }
            }
        }
        return dp[0] - 1;
    }
}