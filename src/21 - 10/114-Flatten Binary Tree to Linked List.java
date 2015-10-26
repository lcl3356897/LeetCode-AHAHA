//Non-Re
public class Solution {
    public void flatten(TreeNode root) {
        while(root != null){
            if(root.left != null){
                TreeNode tmp = root.left;
                while(tmp.right!=null){
                    tmp = tmp.right;
                }
                tmp.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }
}

//Recursively
public class Solution {
    public void flatten(TreeNode root) {
        flattenBT(root);
    }
    
    public TreeNode flattenBT(TreeNode root){
        if(root == null) return null;
        TreeNode left = flattenBT(root.left);
        TreeNode right = flattenBT(root.right);
        if(root.left != null){
            TreeNode tmp = root.right;
            root.right = root.left;
            root.left = null;
            left.right = tmp;
        }
        
        if(right != null) return right;
        if(left != null) return left;
        return root;
    }
}

//
public class Solution {
    private TreeNode pre = null;
    public void flatten(TreeNode root) {
        if(root == null) return;
        
        TreeNode saveRight = root.right;
        if(pre != null){
            pre.left = null;
            pre.right = root;
        }
        pre = root;
        flatten(root.left);
        flatten(saveRight);
    }
}