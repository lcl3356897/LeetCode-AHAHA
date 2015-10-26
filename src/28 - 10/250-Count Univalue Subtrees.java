public class Solution {
	int rst = 0;
	
    public int countUnivalSubtrees(TreeNode root) {
        helper(root);
        return rst;
    }

    private boolean helper(TreeNode node) {
        if(node == null) return true;
        
        boolean l = helper(node.left);
        boolean r = helper(node.right);
        
        if(l && r){
        	if( node.left != null && node.val != node.left.val) return false;
        	if( node.right != null && node.val != node.right.val) return false;
        	
        	rst++;
        	return true;
        }
        return false;
    }
}