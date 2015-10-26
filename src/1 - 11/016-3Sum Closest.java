public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length <= 2){
            return -1;
        }       
        Arrays.sort(nums);
        int rst = nums[0]+nums[1]+nums[nums.length-1];
        for(int i=0;i<nums.length-2;i++){
            if(i>0 && nums[i-1] == nums[i]) continue;
            int j = i+1, k = nums.length - 1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum > target){
                    k--;
                }
                else if(sum < target){
                    j++;
                }
                else{
                    return sum;
                }
                if(Math.abs(target - sum) < Math.abs(target - rst)){
                    rst = sum;
                }
            }
        }
        return rst;
    }
}