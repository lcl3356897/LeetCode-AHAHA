public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if(nums == null || nums.length <= 2){
            return rst;
        }
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            if(i>0 && nums[i-1] == nums[i]) continue;
            int j=i+1, k=nums.length-1;
            while(j<k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum < 0){
                    j++;
                }
                else if(sum > 0){
                    k--;
                }
                else{
                    List<Integer> tmp = new ArrayList<Integer>();
                    tmp.add(nums[i]);tmp.add(nums[j]);tmp.add(nums[k]);
                    if(rst.indexOf(tmp) == -1){
                        rst.add(new ArrayList<Integer>(tmp));
                    }
                    j++;k--;
                }
            }
        }
        return rst;
    }
}