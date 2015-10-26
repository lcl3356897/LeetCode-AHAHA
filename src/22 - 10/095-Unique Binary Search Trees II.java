public class Solution {
    public List<TreeNode> generateTrees(int n) {
    	return generate(1, n);
    }
    private List<TreeNode> generate(int start, int end){
    	List<TreeNode> rst = new ArrayList<TreeNode>();
    	if(start > end) rst.add(null);
    	
    	for(int i=start;i<=end;i++){
    		List<TreeNode> left = generate(start, i-1);
    		List<TreeNode> right = generate(i+1, end);
    		for(TreeNode l : left){
    		    for(TreeNode r : right){
    				TreeNode root = new TreeNode(i);
    				root.left = l;
    				root.right = r;
    				rst.add(root);
    		    }
    		}
    	}
    	
    	return rst;
    }
}