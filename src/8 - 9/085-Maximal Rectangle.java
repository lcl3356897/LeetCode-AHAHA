public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
        	return 0;
        }
        int dp[][] = new int[matrix.length][matrix[0].length+1];
        for(int i=0;i<matrix.length;i++){
        	for(int j=0;j<matrix[0].length;j++){
        		if(matrix[i][j] == '1'){
        			dp[i][j] = i == 0 ? 1 : dp[i-1][j] + 1;
        		}
        	}
        }
        int rst = 0;
        for(int i=0;i<dp.length;i++){
        	rst = Math.max(rst, maxInHst(dp[i]));
        }
        return rst;
    }
    
    public int maxInHst(int[] h){
    	Stack<Integer> st = new Stack<Integer>();
    	int area = 0;
    	for(int i=0;i<h.length;){
    		if(st.empty() || h[i] >= h[st.peek()]){
    			st.push(i++);
    		}
    		else{
    			int index = st.pop();
    			area = Math.max(area, h[index] * (st.empty() ? i : i-st.peek()-1));
    		}
    	}
    	return area;
    }
}