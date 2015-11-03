/**
* HashMap
*/
public class Solution {
    public int majorityElement(int[] nums) {
        if(nums.length == 1){
        	return nums[0];
        }
        HashMap<Integer, Integer> hs  = new HashMap<Interger, Integer>();
        int rst = 0;
        int max = 0;
        for(int i=0;i<nums.length;i++){
        	if(hs.containsKey(nums[i])){
        		hs.put(nums[i], hs.get(nums[i])+1);
        	}
        	else{
        		hs.put(nums[i], 1);
        	}
        	if(hs.get(nums[i]) > max){
        		rst = nums[i];
        		max = hs.get(nums[i]);
        	}
        }
        return rst;
    }
}

/**
* Moore voting algorithm
*/
public class Solution {
    public int majorityElement(int[] nums) {
        if(nums.length == 1){
        	return nums[0];
        }
        int rst = nums[0], count = 1;
        for(int i=1;i<nums.length;i++){
        	if(nums[i] == rst){
        		count++;
        	}
        	else{
        		count--;
        	}
        	if(count == 0){
        		rst = nums[i];
        		count = 1;
        	}
        }
        return rst;
    }
}