//Search for target first. If not, return left
public class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] < target){
                left = mid + 1;
            }
            else if(nums[mid] > target){
                right = mid - 1;
            }
            else{
                return mid;
            }
        }
        return left;
    }
}

//Search for target first. If not, search for target+1.
public class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0){
        	return 0;
        }
        int pivot = BinarySearchBound(nums, target);
        if(nums[pivot] != target){
        	int higher = BinarySearchBound(nums, target+1);
        	if(nums[higher] > target){
        		return higher;
        	}
        	else{
        		return higher + 1;
        	}
        }
        else{
        	return pivot;
        }
    }

    public int BinarySearchBound(int[] nums, int target){
    	int left = 0, right = nums.length - 1;
    	while(left < right){
        	int mid = left + (right - left) / 2;
        	if(nums[mid] < target){
        		left = mid + 1;
        	}
        	else{
        		right = mid;
        	}
        }
        return left;
    }
}