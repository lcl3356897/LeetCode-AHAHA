public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> rst = new ArrayList<String>();
        int prev = lower - 1;
        for (int i = 0; i <= nums.length; i++) {
            int curr = (i == nums.length) ? upper + 1 : nums[i];
            if (curr - prev >= 2) rst.add(make(prev + 1, curr - 1));
            prev = curr;
        }
        return rst;
    }
    
    private String make(int start, int end){
        return start == end ? String.valueOf(start) : start + "->" + end;
    }
}

//

public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
    	List<String> rst = new ArrayList<String>();
    	if(nums == null || nums.length == 0){
    		rst.add( getString(lower, upper) );
    		return rst;
    	}
        if(nums[0] != lower){
        	rst.add( getString(lower, nums[0] - 1) );
        }
        
        int i = 0;
        while(i < nums.length){
        	while(i + 1 < nums.length && nums[i] + 1 == nums[i+1]) i++;
        	if(i != nums.length - 1){
        		rst.add( getString(nums[i] + 1, nums[i + 1] - 1));
        	}
        	else{
        		if(nums[i] != upper) rst.add( getString(nums[i] + 1, upper) );
        	}
        	i++;
        }
        
        return rst;
    }
    
    private String getString(int start, int end){
    	StringBuffer sb = new StringBuffer();
    	if(end == start) sb.append(start);
    	else sb.append(Integer.toString(start) + "->" + Integer.toString(end));
    	return sb.toString();
    }
}