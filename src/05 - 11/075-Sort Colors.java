public class Solution {
    public void sortColors(int[] nums) {
        if(nums == null || nums.length == 0){
            return;
        }
        int p1 = 0, p2 = nums.length - 1, i=0;
        while(i <= p2){
            if(nums[i] == 0){
                int tmp = nums[i];
                nums[i++] = nums[p1];
                nums[p1++] = tmp;
            }
            else if(nums[i] == 2){
                int tmp = nums[i];
                nums[i] = nums[p2];
                nums[p2--] = tmp;
            }
            else{
                i++;
            }
        }
        return;
    }
}