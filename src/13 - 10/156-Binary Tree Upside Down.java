/*
        1
      2   3
    4   5

        4
      5   2
        3   1
*/
public class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode cur = root;
        TreeNode prev = null;
        TreeNode next = null;
        TreeNode tmp = null;
        
        while(cur != null){
            next = cur.left;
            cur.left = tmp;
            tmp = cur.right;
            cur.right = prev;
            prev = cur;
            cur = next;
        }
        
        return prev;
    }
}

//Recursively

public class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
      if (root == null || root.left == null && root.right == null) return root;
    
      TreeNode newRoot = upsideDownBinaryTree(root.left);
    
      root.left.left = root.right;
      root.left.right = root;
    
      root.left = null;
      root.right = null;
    
      return newRoot;
    }
}