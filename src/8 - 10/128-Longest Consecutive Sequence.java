public class Solution {
    public int longestConsecutive(int[] nums) {
    	if(nums == null || nums.length == 0){
    		return 0;
    	}
    	PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
    	for(int i=0;i<nums.length;i++){
    		pq.add(nums[i]);
    	}
    	
    	int rst = 0;
    	while(pq.isEmpty() == false){
    		int number = pq.peek(), times = 0;
    		while(pq.contains(number)){
    			pq.remove(number);
    			number++;times++;
    		}
    		rst = Math.max(rst, times);
    	}
    	
    	
    	return rst;
    }
}