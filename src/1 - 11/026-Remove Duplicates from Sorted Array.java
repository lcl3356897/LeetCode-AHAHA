public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);
        int index = 0;
        for(int i=1;i<nums.length;i++){
            if(nums[i] != nums[index]){
                nums[++index] = nums[i];
            }
        }
        return index+1;
    }
}