public class Solution {
    public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length == 0) return new int[0];
        
        int[] rst = new int[nums.length];
        Arrays.fill(rst, 1);
        
        int left = nums[0];
        for(int i = 1; i < nums.length; i++){
            rst[i] *= left;
            left *= nums[i];
        }
        
        int right = nums[nums.length - 1];
        for(int i = nums.length - 2; i >= 0; i--){
            rst[i] *= right;
            right *= nums[i];
        }

        return rst;
    }
}