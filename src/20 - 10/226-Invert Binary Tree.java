//
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        helper(root);
        return root;
    }
    
    private void helper(TreeNode root){
    	if(root == null) return;
    	TreeNode tmp = root.left;
    	root.left = root.right;
    	root.right = tmp;
    	helper(root.left);
    	helper(root.right);
    }
}

//
public class Solution {
    public TreeNode invertTree(TreeNode root) {
    	if (root == null) return root;
        TreeNode tmp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tmp);
        return root;
    }
}

//
public class Solution {
    public TreeNode invertTree(TreeNode root) {
    	if (root == null) return root;
    	Queue<TreeNode> q = new LinkedList<TreeNode>();
    	q.add(root);
    	while(!q.isEmpty()){
    		TreeNode node = q.poll();
    		TreeNode tmp = node.left;
    		node.left = node.right;
    		node.right = tmp;
    		if(node.left != null) q.add(node.left);
    		if(node.right != null) q.add(node.right);
    	}
        return root;
    }
}