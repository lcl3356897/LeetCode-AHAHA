
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        return depth(root) != -1;
    }
    private int depth(TreeNode root){
        if(root == null) return 0;
        
        int left = depth(root.left);
        int right = depth(root.right);
        
        if(left == -1 || right == -1 || Math.abs(left - right) > 1 ) return -1;
        
        return Math.max(left, right) + 1;
    }
}

//
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        
        if(Math.abs(depth(root.left) - depth(root.right)) > 1) return false;
        
        return isBalanced(root.left) && isBalanced(root.right);
    }
    private int depth(TreeNode root){
        if(root == null) return 0;
        
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}