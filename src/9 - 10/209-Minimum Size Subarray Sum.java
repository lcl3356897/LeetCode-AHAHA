public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int sum = nums[0], start = 0, rst = sum >= s ? 1 : Integer.MAX_VALUE;
        for(int i = 1; i < nums.length; i++){
            sum += nums[i];
            while(sum >= s && start <= i){
                rst = Math.min(rst, i - start + 1);
                sum -= nums[start++];
            }
        }   
        return rst == Integer.MAX_VALUE ? 0 : rst;
    }
}

//

public class Solution {
	public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0){
        	return 0;
        }
        int[] sum = new int[nums.length+1];
        int rst = Integer.MAX_VALUE;
        for(int i=1;i<sum.length;i++){
        	sum[i] = sum[i-1] + nums[i-1];
        }
        for(int i=0;i<sum.length;i++){
        	int right = BinarySearch(sum, i+1, sum.length-1, sum[i]+s);
        	if(right == sum.length) break;
        	rst = Math.min(rst, right-i);
        }
        return rst == Integer.MAX_VALUE ? 0 : rst;
	}

    int BinarySearch(int[] sum, int left, int right, int target){//Find right bound
    	while(left <= right){
            int mid = left + (right - left) / 2;
            if(sum[mid] == target){
                return mid;
            }
            else if(sum[mid] > target){
                right = mid-1;
            }
            else{
                left = mid + 1;
            }
        }
        return left;
    }
}