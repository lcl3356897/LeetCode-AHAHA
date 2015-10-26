public class Solution {
	private List<String> rst = new ArrayList<String>();
	
    public List<String> binaryTreePaths(TreeNode root) {
        helper(root, "");
        return rst;
    }
    
    private void helper(TreeNode root, String path){
    	if(root == null) return;
    	if(root.left == null && root.right == null){
    		path += "->" + root.val;
    		rst.add( new String(path.substring(2)) );
    	}
    	
    	helper(root.left, path + "->" + root.val);
    	helper(root.right, path + "->" + root.val);
    }
}