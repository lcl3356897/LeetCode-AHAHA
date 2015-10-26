//find left bound, and left bound of target+1
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] rst = {-1, -1};
        if(nums == null || nums.length == 0){
            return rst;
        }       
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
        if(nums[left] != target) return rst;
        rst[0] = left;
        left = 0; right = nums.length - 1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] < target+1){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }
        rst[1] = nums[left] == target ? left : left - 1;
        return rst;
    }
}

//BinarySearch left bound & BinarySearch right bound Again
/*
search for left  保证l左侧的都小于target
    while(l < r){
        m = l + (r - l) / 2;
        if(nums[m] < target){
            l = m + 1;
        }
        else{
            r = m - 1;
        }
    }
    return left;
search for right   保证r右侧的都大于target
    while(l < r){
        m = l + (r - l) / 2;
        if(nums[m] > target){
            r = m - 1;
        }
        else{
            l = m + 1;
        }
    }
    return right;
*/
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] rst = {-1, -1};
        if(nums == null || nums.length == 0){
            return rst;
        }
        int pivot = BinarySearch(nums, target, 0, nums.length-1);
        if(pivot == -1){
            return rst;
        }
        else{
            int left = pivot, leftMost = pivot;
            while(left > 0){
                left = BinarySearch(nums, target, 0, left-1);
                if(left != -1 && left < leftMost){
                    leftMost = left;
                }
                if(left == -1){
                    break;
                }
            }

            int right = pivot, rightMost = pivot;
            while(right <nums.length){
                right = BinarySearch(nums, target, right+1, nums.length-1);
                if(right != -1 && right > rightMost){
                    rightMost = right;
                }
                if(right == -1){
                    break;
                }
            }
            rst[0] = leftMost;
            rst[1] = rightMost;
        }
        return rst;
    }

    public int BinarySearch(int[] nums, int target, int start, int end){
        int left = start, right = end;
        while(left<=right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] < target){
                left = mid + 1;
            }
            else{//nums[mid] > target
                right = mid - 1;
            }
        }
        return -1;
    }
}

//Binary Search for the pivot. Then from this point search left and right, respectively.
public class Solution {
    public int[] searchRange(int[] nums, int target) {
    	int[] rst = {-1, -1};
        if(nums == null || nums.length == 0){
        	return rst;
        }
        int pivot = BinarySearch(nums, target);
        if(pivot == -1){
        	return rst;
        }
        else{
	        for(int i = pivot; i>=0;i--){
	        	if(nums[i] == target){
	        		rst[0] = i;
	        	}
	        }
	        for(int i=pivot; i<nums.length;i++){
	        	if(nums[i] == target){
	        		rst[1] = i;
	        	}
	        }
        }
        return rst;
    }

    public int BinarySearch(int[] nums, int target){
		int left = 0, right = nums.length-1;
		while(left<=right){
			int mid = left + (right - left) / 2;
			if(nums[mid] == target){
				return mid;
			}
			else if(nums[mid] < target){
				left = mid + 1;
			}
			else{//nums[mid] > target
				right = mid - 1;
			}
		}
		return -1;
	}
}
