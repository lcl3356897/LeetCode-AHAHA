public class Solution {
    private int sum = 0;
    
    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return sum;
    }
    
    private void helper(TreeNode root, int path){
        if(root == null) return;
        if(root.left == null && root.right == null){
            sum += path * 10 + root.val;
        }
        
        helper(root.left, path * 10 + root.val);
        helper(root.right, path * 10 + root.val);
    }
}