public class Solution {
	public int numDistinct(String s, String t) {
        int n = s.length(), m = t.length();
        int[] dp = new int[n+1];
        Arrays.fill(dp, 1);
        
        for(int i=1; i<=m; i++) {
            int upLeft = dp[0];
            dp[0] = 0;
            for(int j=1; j<=n; j++) {
                int temp = dp[j];
                dp[j] = dp[j-1];
                if(s.charAt(j-1) == t.charAt(i-1)) dp[j] += upLeft;
                upLeft = temp;
            }
        }
        return dp[n];
	}
}