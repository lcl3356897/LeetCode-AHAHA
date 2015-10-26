public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0){
            return rst;
        }
        Arrays.sort(nums);
        List<Integer> path = new ArrayList<Integer>();
        helper(nums, rst, path, 0);
        return rst;
    }
    public void helper(int[] nums, List<List<Integer>> rst, List<Integer> path, int index){
        if(rst.indexOf(path) == -1){
            rst.add(new ArrayList<Integer>(path));
        }
        for(int i=index;i<nums.length;i++){
            path.add(nums[i]);
            helper(nums, rst, path, i+1);
            path.remove(path.size() - 1);
        }
    }
}

//
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0){
            return rst;
        }
        double number = Math.pow(2, nums.length) - 1;
        Arrays.sort(nums);
        for(int i = 0; i <= number; i++){
            rst.add(new ArrayList<Integer>(helper(nums, i)));
        }
        return rst;
   }
   public List<Integer> helper(int[] nums, int number){
       List<Integer> path = new ArrayList<Integer>();
       int i=0;
       while(number > 0){
           if(number % 2 == 1){
               path.add(nums[i]);
           }
           number >>= 1;
           i++;
       }
       return path;
   } 
}