public class Solution {
	public int maxProfit(int[] prices) {
     	if(prices == null || prices.length <= 1){
     		return 0;
     	}   
     	int dp1[] = new int[prices.length];
     	int dp2[] = new int[prices.length];
     	
     	int min = prices[0];
     	for(int i=1;i<prices.length;i++){
     		min = Math.min(min, prices[i]);
     		dp1[i] = Math.max(dp1[i-1], prices[i] - min);
     	}
     	
     	int max = prices[prices.length - 1];
     	for(int i=prices.length - 2;i>=0;i--){
     		max = Math.max(max, prices[i]);
     		dp2[i] = Math.max(dp2[i+1], max - prices[i]);
     	}
     	
     	int rst = 0;
     	for(int i=0;i<prices.length;i++){
     		rst = Math.max(rst, dp1[i] + dp2[i]);
     	}
     	
     	return rst;
   }
}