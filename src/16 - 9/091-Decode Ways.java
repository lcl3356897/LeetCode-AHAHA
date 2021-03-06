public class Solution {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0 || s.charAt(0) < '1' || s.charAt(0) > '9') return 0;
        
        int[] dp = new int[s.length() + 1];
        dp[0] = dp[1] = 1;
        for(int i = 1; i < s.length(); i++){
            if(!Character.isDigit(s.charAt(i))) return 0;
            int num = (s.charAt(i - 1) - '0') * 10 + (s.charAt(i) - '0');
            if(10 <= num && num <= 26) dp[i+1] += dp[i-1];
            if(s.charAt(i) != '0') dp[i+1] += dp[i];
            if(dp[i+1] == 0) return 0;
        }
        return dp[s.length()];
    }
}