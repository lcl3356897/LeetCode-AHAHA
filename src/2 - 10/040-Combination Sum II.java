public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
     	List<List<Integer>> rst = new ArrayList<List<Integer>>();
     	if(candidates == null || candidates.length == 0){
     		return rst;
     	}   
     	Arrays.sort(candidates);
     	List<Integer> path = new ArrayList<Integer>();
     	find(candidates, target, rst, path, 0);
     	return rst;
    }

    public void find(int[] candidates, int target, List<List<Integer>> rst, List<Integer> path, int index){
    	if(target == 0){
    		if(!rst.contains(path)){
    			rst.add(new ArrayList<Integer>(path));
    		}
    		return;
    	}
    	if(target < 0){
    		return;
    	}

    	for(int i=index;i<candidates.length;i++){
    		path.add(candidates[i]);
    		find(candidates, target-candidates[i], rst, path, i + 1);
    		path.remove(path.size() - 1);
    	}
    }
}