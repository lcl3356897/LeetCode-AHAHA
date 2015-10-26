public class Solution {
	private List<List<Integer>> rst = new ArrayList<List<Integer>>();
	
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
    	List<Integer> path = new ArrayList<Integer>();
        helper(root, sum, path);
        return rst;
    }
    
    private void helper(TreeNode root, int sum, List<Integer> path){
    	if(root == null) return;
    	path.add( root.val );
    	if(root.val == sum && root.left == null && root.right == null){
    		rst.add(new ArrayList<Integer>(path));
    	}
    	helper(root.left, sum - root.val, path);
    	helper(root.right, sum - root.val, path);
    	path.remove(path.size() - 1);
    }
}