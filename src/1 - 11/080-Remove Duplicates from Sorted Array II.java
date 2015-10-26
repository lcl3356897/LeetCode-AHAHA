public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int index = 0, occur = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i] == nums[index]){
                if(occur == 2){
                    continue;
                }
                occur++;
            }
            else{
                occur = 1;
            }
            nums[++index] = nums[i];
        }
        return index+1;
    }
}