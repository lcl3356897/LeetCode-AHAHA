public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> rst = new ArrayList<String>();
        if(nums == null || nums.length == 0){
            return rst;
        }
        Arrays.sort(nums);
        for(int i=0;i<nums.length;){
            int j=i+1;
            for(;j<nums.length && nums[j-1] + 1 == nums[j];j++);
            if(j > i+1){
                rst.add(new String(nums[i] + "->" + nums[j-1]));
            }
            else{
                rst.add(new String(nums[i]+""));
            }
            i = j;
        }
        return rst;
    }
}