public class Solution {
	private int rst = Integer.MIN_VALUE;
	
	public int maxPathSum(TreeNode root) {
	    calculateSum(root);
	    return rst;
    }
 
    public int calculateSum(TreeNode root) {
    	if (root == null) return 0;
     
    	int left = calculateSum(root.left);
    	int right = calculateSum(root.right);
     
    	int current = Math.max(root.val, Math.max(root.val + left, root.val + right));
     
    	rst = Math.max(rst, Math.max(current, left + root.val + right));
     
    	return current;
    }
}