public class Solution {
    public int maxSubArray(int[] nums) {
     	if(nums == null || nums.length == 0) return 0;

     	int[] dp = new int[nums.length];
     	dp[0] = nums[0];
     	int max = nums[0];
     	for(int i = 1; i < nums.length; i++){
     		dp[i] = Math.max(0, dp[i - 1]) + nums[i];
     		max = Math.max(max, dp[i]);
     	}   
     	return max;
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