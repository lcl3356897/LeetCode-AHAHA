public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums == null || nums.length == 0 || k <= 0){
        	return false;
        }
        TreeSet<Integer> ts = new TreeSet<Integer>();
        for(int i=0;i<nums.length;i++){
        	int n = nums[i];
        	if(ts.floor(n) != null && n <= t + ts.floor(n) || ts.ceiling(n) != null && n + t >= ts.ceiling(n)){
        		return true;
        	}
        	ts.add(n);
        	if(i >= k){
        		ts.remove(nums[i-k]);
        	}
        }
        return false;
    }
}