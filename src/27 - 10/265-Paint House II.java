public class Solution {
	public int minCostII(int[][] costs) {
	    if(costs == null || costs.length == 0 || costs[0].length == 0) return 0;
	
	    int n = costs.length, k = costs[0].length;
	    if(k == 1) return (n==1? costs[0][0] : -1);
	
	    int prevMin = 0, prevMinInd = -1, prevSecMin = 0;//prevSecMin always >= prevMin
	    for(int i = 0; i<n; i++) {
	        int min = Integer.MAX_VALUE, minInd = -1, secMin = Integer.MAX_VALUE;
	        for(int j = 0; j<k;  j++) {
	            int val = costs[i][j] + (j == prevMinInd? prevSecMin : prevMin);
	            if(val < min) {//when val < min, 
	                secMin = min;
	                min = val;
	                minInd = j;
	            } else if(val < secMin) { //when min<=val< secMin
	                secMin = val;
	            }
	        }
	        prevMin = min;
	        prevMinInd = minInd;
	        prevSecMin = secMin;
	    }
	    return prevMin;
	}
}