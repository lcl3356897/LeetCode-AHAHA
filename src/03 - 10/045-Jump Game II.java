public class Solution {
    public int jump(int[] nums) {
        if(nums == null || nums.length == 0){
        	return -1;
        }
        int curMax = 0, i = 0, step = 0;
        while(curMax < nums.length-1){
        	int lastMax = curMax;
        	for(;i<=lastMax;i++){
        		curMax = Math.max(curMax, i+nums[i]);
        	}
        	if(curMax == lastMax){
        		return -1;
        	}
        	step++;
        }
        return step;
    }
}