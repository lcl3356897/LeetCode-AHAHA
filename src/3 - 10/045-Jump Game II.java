public class Solution {
    public int jump(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        int step = 0, max = 0, i = 0;
        while(max < nums.length - 1){
            int prevMax = max;
            for(; i <= prevMax; i++){
                max = Math.max(max, i + nums[i]);
            }
            if(prevMax == max) return -1;
            step++;
        }
        return step;
    }
}