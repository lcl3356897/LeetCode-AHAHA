public class Solution {
    public int singleNumber(int[] nums) {
        if(nums == null || nums.length == 0){
        	return 0;
        }
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length;i++){
        	if(hm.containsKey(nums[i])){
        		hm.put(nums[i], hm.get(nums[i])+1);
        	}
        	else{
        		hm.put(nums[i], 1);
        	}
        }
        for(int key : hm.keySet()){
        	if(hm.get(key) == 1){
        		return key;
        	}
        }
        return 0;
    }
}

//

public class Solution {
    public int singleNumber(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int[] bit = new int[32];
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<32;j++){
                int tmp;
                if((tmp = nums[i] >> j) == 0) break;
                bit[j] += tmp & 1;
            }
        }
        int rst = 0;
        for(int i=0;i<32;i++){
            rst += bit[i] % 3 << i;
        }
        return rst;
    }
}