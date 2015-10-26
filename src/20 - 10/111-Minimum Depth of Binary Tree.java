public class Solution {
    public int minDepth(TreeNode root) {
        if(root == null){
    		return 0;
    	}
    	return getMin(root);
    }
    
    private int getMin(TreeNode root){
    	if(root == null) return Integer.MAX_VALUE;
    	if(root.left == null && root.right == null) return 1;
    	return Math.min(getMin(root.left), getMin(root.right)) + 1;
    }
}

//

public class Solution {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null) return minDepth(root.right)+1;
        if(root.right == null) return minDepth(root.left)+1;
        return Math.min(minDepth(root.left),minDepth(root.right))+1;
    }
}