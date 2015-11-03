public class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0){
        	return Integer.MIN_VALUE;
        }
        int left = 0, right = nums.length - 1;
        while(left < right){
        	int mid = left + (right - left) / 2;
        	if(nums[mid] < nums[right]){
        		right = mid;
        	}
        	else{
        		left = mid + 1;
        	}
        }
        return nums[left];
    }
}