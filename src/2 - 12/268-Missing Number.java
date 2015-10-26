//Use Sum
public class Solution {
    public int missingNumber(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int sum = (nums.length+1) * nums.length / 2;
        for(int i=0;i<nums.length;i++){
            sum -= nums[i];
        }
        return sum;
    }
}

//Use XOR
public class Solution {
    public int missingNumber(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int rst = 0;
        for(int i=0;i<nums.length;i++){
            rst ^= nums[i];
            rst ^= i+1;
        }
        return rst;
    }
}