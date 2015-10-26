//
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k == 0){
            return false;
        }
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length;i++){
            if(hm.containsKey(nums[i])){
                if(Math.abs(i - hm.get(nums[i])) <= k) return true;
            }
            hm.put(nums[i], i);
        }
        return false;
    }
}

//
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k == 0){
            return false;
        }
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<Integer, ArrayList<Integer>>();
        for(int i=0;i<nums.length;i++){
        	if(hm.containsKey(nums[i])){
        		List<Integer> tmp = hm.get(nums[i]);
        		for(int j=0;j<tmp.size();j++){
        			if(Math.abs(i - tmp.get(j)) <= k){
        				return true;
        			}
        		}
        		hm.get(nums[i]).add(i);
        	}
        	else{
        		List<Integer> tmp = new ArrayList<Integer>();
        		tmp.add(i);
        		hm.put(nums[i], new ArrayList<Integer>(tmp));
        	}
        }
        return false;
    }
}
