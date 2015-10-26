fpublic class Solution {
   public boolean canJump(int[] nums) {
 		if(nums == null || nums.length == 0){
 			return false;
 		}
 		int max = 0;
 		for(int i=0;i<nums.length;i++){
 			if(i > max || max>=(nums.length - 1)){
 				break;
 			}
 			max = Math.max(max, i+nums[i]);
 		}
 		return max>=(nums.length - 1) ? true : false;
    }
}

//
public class Solution {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0){
            return false;
        }
        int max = 0;
        for(int i=0;i < nums.length && i <= max && max < nums.length - 1; i++){
            max = Math.max(max, nums[i] + i);
        }
        return max >= nums.length - 1;
    }
}