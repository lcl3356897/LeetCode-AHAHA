public class Solution {
    List<List<Integer>> rst = new ArrayList<List<Integer>>();
    List<Integer> path = new ArrayList<Integer>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        if(k <= 0 || n <= 0) return rst;
        helper(k, n, 1);
        return rst;
    }

    private void helper(int k, int n, int start){
        if(n == 0 && k == 0){
            if(!rst.contains(path)){
                rst.add(new ArrayList<Integer>(path));
            }
            return;
        }
        if(n <= 0 || k == 0) return;

        for(int i = start; i <= 9; i++){
            path.add(i);
            helper(k - 1, n - i, i + 1);
            path.remove(path.size() - 1);
        }
    }
}