public class Solution {
    public int maxSubArray(int[] nums) {
 		if(nums == null || nums.length == 0){
 			return 0;
 		}
 		int[] dp = new int[nums.length];
 		dp[0] = nums[0];
 		for(int i=1;i<nums.length;i++){
 			dp[i] = dp[i-1] > 0 ? dp[i-1] : 0; 
 			dp[i] += nums[i];
 		}
 		int rst = nums[0];
 		for(int i=0;i<nums.length;i++){
 			rst = Math.max(rst, dp[i]);
 		}
 		return rst;
    }
}

//
public class Solution {
    public int maxSubArray(int[] nums) {
 		if(nums == null || nums.length == 0){
 			return 0;
 		}
 		int prev = nums[0];
 		int rst = nums[0];
 		for(int i=1;i<nums.length;i++){
 			prev = ( prev > 0 ? prev : 0) + nums[i]; 
 			rst = Math.max(rst, prev);
 		}
 		return rst;
    }
}