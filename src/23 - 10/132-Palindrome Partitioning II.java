public class Solution {
	public int minCut(String s) {
		int len = s.length();
		int[] dp = new int[len+1];
		boolean[][] is = new boolean[len][len];
		for(int i=0;i<=len;i++){
			dp[i] = len - i;
		}
		for(int i=len-1;i>=0;i--){
			for(int j=i;j<len;j++){
				if((i+1 > j-1 || is[i+1][j-1]) && s.charAt(i) == s.charAt(j)){
					is[i][j] = true;
					dp[i] = Math.min(dp[i], dp[j+1] + 1);
				}
			}
		}
		return dp[0] - 1;
    }
}