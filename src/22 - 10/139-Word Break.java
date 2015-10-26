public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if(s == null || s.length() == 0) return false;
        boolean[] dp = new boolean[s.length()];
        
        for(int i=0;i<s.length();i++){
        	if(wordDict.contains(s.subSequence(0, i+1))){
        		dp[i] = true;
        	}
        	else{
        		for(int j=0;j<i;j++){
        			if(dp[j] && wordDict.contains(s.substring(j+1, i+1))){
        				dp[i] = true;
        				break;
        			}
        		}
        	}
        }
        return dp[s.length() - 1];
    }
}