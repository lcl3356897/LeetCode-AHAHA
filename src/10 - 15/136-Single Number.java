public class Solution {
    public int singleNumber(int[] nums) {
        int rst=0;
        for(int i=0;i<nums.length;i++){
            rst ^= nums[i];
        }
        return rst;
    }
}