public class Solution {
    public void rotate(int[] nums, int k) {
    	if(k <= 0){
 			return;
 		}
    	k = k % nums.length;
    	helper(nums, 0, nums.length - 1 - k);
    	helper(nums, nums.length - k, nums.length - 1);
    	helper(nums, 0, nums.length - 1);
    }
    public void helper(int[] nums, int left, int right){
    	while(left < right){
    		int tmp = nums[left];
    		nums[left++] = nums[right];
    		nums[right--] = tmp;
    	}
    }
}