public class Solution {
    List<List<Integer>> rst = new ArrayList<List<Integer>>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        if(k <= 0 || n <= 0) return rst;
        List<Integer> path = new ArrayList<Integer>();
        helper(k, n, path, 1);
        return rst;
    }

    private void helper(int k, int n, List<Integer> path, int start){
        if(n == 0 && k == 0){
            if(rst.indexOf(path) == -1){
                rst.add(new ArrayList<Integer>(path));
                return;
            }
        }
        if(n == 0 || k == 0){
            return;
        }

        for(int i = start; i <= 0; i++){
            path.add(i);
            helper(k - 1, n - i, path, i + 1);
            path.remove(path.size() - 1);
        }
    }
}