public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        if(nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        int rst = 0;
        for(int i = 0; i < nums.length - 2; i++){
            //if(i > 0 && nums[i-1] == nums[i]) continue;
            int j = i + 1, k = nums.length - 1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum >= target){
                    k--;
                }
                else{
                    rst += k - j;
                    j++;
                }
            }
        }
        return rst;
    }
}