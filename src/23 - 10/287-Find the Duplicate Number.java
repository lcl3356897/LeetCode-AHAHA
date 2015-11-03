public class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0, rst = 0;
        while(true){
        	slow = nums[slow];
        	fast = nums[nums[fast]];
        	if(slow == fast) break;
        }
        
        while(true){
        	slow = nums[slow];
        	rst = nums[rst];
        	if(rst == slow) return rst;
        }
    }
}

//

public class Solution {
    public int findDuplicate(int[] nums) {
        int left = 1, right = nums.length - 1;
        while(left < right){
            int mid = left + (right - left) / 2;
            int count = 0;
            for(int n : nums){
                if(n <= mid) count++;
            }
            if(count <= mid) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}