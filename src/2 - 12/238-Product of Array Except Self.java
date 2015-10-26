public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] rst = new int[nums.length];
        if(nums == null || nums.length == 0){
        	return rst;
        }
        Arrays.fill(rst, 1);
        int left = 1;
        for(int i=1;i<nums.length;i++){
        	left *= nums[i-1];
        	rst[i] *= left;
        }
        int right  = 1;
        for(int i=nums.length-2;i>=0;i--){
        	right *= nums[i+1];
        	rst[i] *= right;
        }
        return rst;
    }
}