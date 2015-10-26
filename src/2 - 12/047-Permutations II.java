public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0){
            return rst;
        }
        
        Arrays.sort(nums);
        List<Integer> path = new ArrayList<Integer>();
        boolean[] used = new boolean[nums.length];
        generate(rst, path, nums, used);
        
        return rst;
    }

    public void generate(List<List<Integer>> rst, List<Integer> path, int[] nums, boolean[] used){
        if(path.size() == nums.length){
            if(rst.indexOf(path) == -1){
                rst.add(new ArrayList<Integer>(path));
            }
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i-1] == nums[i] && !used[i-1]){
                continue;
            }
            if(!used[i]){
                used[i] = true;
                path.add(nums[i]);
                generate(rst, path, nums, used);
                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
    }
}