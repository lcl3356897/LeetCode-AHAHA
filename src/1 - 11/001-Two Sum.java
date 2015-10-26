public class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length <=2){
        	return null;
        }
        int[] rst = new int[2];
        HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++){
        	hs.put(nums[i], i);
        }
        for(int i=0; i<nums.length; i++){
        	if( hs.containsKey(target - nums[i] ) && hs.get(target - nums[i]) != i ){
        		rst[0] = i+1;
        		rst[1] = hs.get(target - nums[i])+1;
        		return rst;
        	}
        }
        return rst;
    }
}