//Recursively

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        
        return helper(root.left, root.right);
    }
    
    private boolean helper(TreeNode l, TreeNode r){
    	if(l == null && r == null) return true;
    	if((l == null) ^ (r == null)) return false;
    	if(l.val != r.val) return false;
    	
    	return helper(l.left, r.right) && helper(l.right, r.left);
    }
}

//Iteratively

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        Queue<TreeNode> l = new LinkedList<TreeNode>(),
                            r = new LinkedList<TreeNode>();
        l.add(root.left);
        r.add(root.right);
        while(!l.isEmpty() && !r.isEmpty()){
            TreeNode t1 = l.poll(),
                     t2 = r.poll();
            if((t1 == null) ^ (t2 == null)) return false;
            if(t1 == null && t2 == null) continue;
            if(t1.val != t2.val) return false;
            l.add(t1.left);l.add(t1.right);
            r.add(t2.right);r.add(t2.left);
        }
        return true;
    }
}