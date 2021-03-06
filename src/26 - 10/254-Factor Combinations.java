public class Solution {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    
	public List<List<Integer>> getFactors(int n) {
		helper(result, new ArrayList<Integer>(), n, 2);
		return result;
	}

	public void helper(List<List<Integer>> result, List<Integer> path, int n, int start){
		if (n <= 1) {
			if (path.size() > 1) {
				result.add(new ArrayList<Integer>(path));
			}
			return;
		}

		for (int i = start; i <= n; ++i) {
			if (n % i == 0) {
				path.add(i);
				helper(result, path, n/i, i);
            	path.remove(path.size()-1);
			}
		}
	}
}