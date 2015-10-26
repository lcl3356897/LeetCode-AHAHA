public class Solution {
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length < 2){
        	return;
        }
        int p = 0;
        for(int i = nums.length-2; i >= 0; i--){
        	if(nums[i] < nums[i+1]){
        		p = i;
        		break;
        	}
        }
        int q = 0;
        for(int i = nums.length-1; i > p; i--){
        	if(nums[i] > nums[p]){
        		q = i;
        		break;
        	}
        }

        if(p == 0 && q == 0){
        	Arrays.sort(nums);
        	return;
        }

        int tmp = nums[p];
        nums[p] = nums[q];
        nums[q] = tmp;
        //No need to sort. 
        //The order from last to p+1 must be increasing order, reverse it
        Arrays.sort(nums, p+1, nums.length);
    }
}