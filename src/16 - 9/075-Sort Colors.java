public class Solution {
    public void sortColors(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int p0 = 0, p1 = 0, p2 = nums.length - 1;
        while(p1 <= p2){
            if(nums[p1] == 0){
                int tmp = nums[p1];
                nums[p1++] = nums[p0];
                nums[p0++] = tmp;
            }
            else if(nums[p1] == 2){
                int tmp = nums[p1];
                nums[p1] = nums[p2];
                nums[p2--] = tmp;
            }
            else{
                p1++;
            }
        }
    }
}