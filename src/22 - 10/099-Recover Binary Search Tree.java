public class Solution {
	private TreeNode w1 = null;
	private TreeNode w2 = null;
	private TreeNode pre = null;
	
    public void recoverTree(TreeNode root) {
        if(root == null) return;
        helper(root);
        int tmp = w1.val;
        w1.val = w2.val;
        w2.val = tmp;
    }
    
    private void helper(TreeNode root){
    	if(root == null) return;
    	helper(root.left);
    	if(pre != null && pre.val > root.val){
    		if(w1 == null){
    			w1 = pre;
    			w2 = root;
    		}
    		else{
    			w2 = root;
    		}
    	}
    	pre = root;
    	helper(root.right);
    }
}