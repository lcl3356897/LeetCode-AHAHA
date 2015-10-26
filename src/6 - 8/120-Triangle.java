//Reverse from bottom to top
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0 || triangle.get(0).size() == 0){
            return 0;
        }
        int[] dp = new int[triangle.get(triangle.size()-1).size()];
        for(int i=0;i<triangle.get(triangle.size()-1).size();i++){
            dp[i] = triangle.get(triangle.size()-1).get(i);
        }
        for(int i=triangle.size()-2;i>=0;i--){
            for(int j=0;j<triangle.get(i).size();j++){
                dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}

//O(k) space
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0 || triangle.get(0).size() == 0){
        	return 0;
        }
        int[] dp = new int[triangle.get(triangle.size()-1).size()];
        dp[0] = triangle.get(0).get(0);
        for(int i=1;i<triangle.size();i++){
        	int prev = dp[0];
        	dp[0] += triangle.get(i).get(0);
        	for(int j=1;j<triangle.get(i).size();j++){
        		int cost = j < triangle.get(i-1).size() ? dp[j] : Integer.MAX_VALUE;
        		cost = Math.min(cost, prev);
        		prev = dp[j];
        		dp[j] = cost + triangle.get(i).get(j);
        	}
        }
        int min = dp[0];
        for(int i=1;i<dp.length;i++){
        	min = Math.min(min, dp[i]);
        }
        return min;
    }
}

//

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0 || triangle.get(0).size() == 0){
        	return 0;
        }
        int[][] dp = new int[triangle.size()][triangle.get(triangle.size()-1).size()];
        dp[0][0] = triangle.get(0).get(0);
        for(int i=1;i<triangle.size();i++){
        	for(int j=0;j<triangle.get(i).size();j++){
        		int tmp = j < triangle.get(i-1).size() ? dp[i-1][j] : Integer.MAX_VALUE;
        		if(j > 0){
        			tmp = Math.min(tmp, dp[i-1][j-1]);
        		}
        		dp[i][j] = tmp + triangle.get(i).get(j);
        	}
        }
        int min = dp[triangle.size()-1][0];
        for(int i=1;i<triangle.get(triangle.size()-1).size();i++){
        	min = Math.min(min, dp[triangle.size()-1][i]);
        }
        return min;
    }
}