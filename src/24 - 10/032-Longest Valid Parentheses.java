public class Solution {
	public int longestValidParentheses(String s) {
    	int max = 0;
    	Stack<Integer> st = new Stack<Integer>();
    	for(int i=0;i<s.length();i++){
    		char c = s.charAt(i);
    		if(c == '('){
    			st.add(i);
    		}
    		else{//c == ')'
    			if(st.isEmpty() || s.charAt(st.peek()) == ')'){
    				st.add(i);
    			}
    			else{
    				st.pop();
    				max = Math.max(max, st.isEmpty() ? i+1 : i-st.peek());
    			}
    		}
    	}
    	return max;
    }
}

//DP

public class Solution {
	public int longestValidParentheses(String s) {
        if(s == null || s.length() < 2) return 0;
        int max = 0;
        int[] dp = new int[s.length()];
        for(int i=1;i<s.length();i++){
        	if(s.charAt(i) == '(') continue;
        	//s.charAt(i) == ')'
        	if(s.charAt(i-1) == '('){
        		dp[i] = 2;
        		if(i-2 >= 0) dp[i] += dp[i-2];
        	}
        	else{//s.charAt(i-1) == ')'
        		if(dp[i-1] > 0){
        			if(i-dp[i-1]-1 >=0 && s.charAt(i-dp[i-1]-1) == '('){
        				dp[i] = dp[i-1]+2;
        				if(i - dp[i-1] - 2 >= 0) dp[i] += dp[i-dp[i-1]-2];
        			}
        		}
        	}
        	max = Math.max(max, dp[i]);
        }
        return max;
    }
}