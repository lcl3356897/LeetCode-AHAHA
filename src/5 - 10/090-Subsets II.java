public class Solution {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
     	List<List<Integer>> rst = new ArrayList<List<Integer>>();
     	if(nums == null || nums.length == 0){
     		return rst;
     	}
     	Arrays.sort(nums);
     	boolean[] used = new boolean[nums.length];
     	List<Integer> path = new ArrayList<Integer>();
     	helper(nums, rst, path, 0, used);
     	return rst;
    }
    public void helper(int[] nums, List<List<Integer>> rst, List<Integer> path, int start, boolean[] used){
    	if(rst.indexOf(path) == -1){
    		rst.add(new ArrayList<Integer>(path));
    	}
    	for(int i=start;i<nums.length;i++){
    	    if(i > 0 && nums[i-1] == nums[i] && used[i-1] == false){
    	        continue;
    	    }
    	    if(used[i] == false){
    	    	used[i] = true;
        		path.add(nums[i]);
        		helper(nums, rst, path, i+1, used);
        		path.remove(path.size() - 1);
        		used[i] = false;
    	    }
    	}
    }
}

//Not need boolean[] used
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        if(num == null || num.length ==0) {
            return result;
        }
        Arrays.sort(num);
        subsetsHelper(result, list, num, 0);

        return result;
    }

    private void subsetsHelper(List<List<Integer>> result,
        List<Integer> list, int[] num, int pos) {

        result.add(new ArrayList<Integer>(list));
        
        for (int i = pos; i < num.length; i++) {
            if ( i != pos && num[i] == num[i - 1]) {
                continue;
            }    
            list.add(num[i]);
            subsetsHelper(result, list, num, i + 1);
            list.remove(list.size() - 1);
        }
    }
}


//
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0){
            return rst;
        }
        double number = Math.pow(2, nums.length) - 1;
        Arrays.sort(nums);
        for(int i=0;i<=number;i++){
            List<Integer> tmp = helper(nums, i);
            if(rst.indexOf(tmp) == -1){
                rst.add(tmp);
            }
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