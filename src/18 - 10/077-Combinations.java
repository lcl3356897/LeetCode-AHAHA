public class Solution {
	List<List<Integer>> rst = new ArrayList<List<Integer>>();
	List<Integer> path = new ArrayList<Integer>();
	
    public List<List<Integer>> combine(int n, int k) {
    	if(n <= k){
    		for(int i = 1; i <= n; i++){
    			path.add(i);
    		}
    		rst.add(path);
    		return rst;
    	}
    	helper(n, k, 1);
    	return rst;
    }
    
    private void helper(int n, int k, int start){
    	if( k == 0 ){
    		rst.add(new ArrayList<Integer>(path));
    		return;
    	}
    	for(int i = start; i <= n; i++){
    		path.add(i);
    		helper(n, k - 1, i + 1);
    		path.remove(path.size() - 1);
    	}
    }
}