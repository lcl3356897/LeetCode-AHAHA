public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0){
        	return rst;
        }
        List<Integer> path = new ArrayList<Integer>();
        generate(rst, path, nums);
        return rst;
    }

    public void generate(List<List<Integer>> rst, List<Integer> path, int[] nums){
    	if(path.size() == nums.length){
    		rst.add(new ArrayList<Integer>(path));
    	}
    	for(int i=0;i<nums.length;i++){
    		if(path.contains(nums[i])){
    			continue;
    		}
    		path.add(nums[i]);
    		generate(rst, path, nums);
    		path.remove(path.size() - 1);
    	}
    }
}