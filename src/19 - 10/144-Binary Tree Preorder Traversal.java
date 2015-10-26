public class Solution {
    List<Integer> rst = new ArrayList<Integer>();
    
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) return rst;
        preorder(root);
        return rst;
    }
    
    private void preorder(TreeNode root){
        rst.add(root.val);
        if(root.left != null) preorder(root.left);
        if(root.right != null) preorder(root.right);
    }
}


//

public class Solution {
	List<Integer> rst = new ArrayList<Integer>();
	
	public List<Integer> preorderTraversal(TreeNode root) {
		if(root == null)
            return rst;
 
        Stack<TreeNode> st = new Stack<TreeNode>();
        st.push(root);
 
        while(!st.empty()){
            TreeNode n = st.pop();
            rst.add(n.val);
 
            if(n.right != null) st.push(n.right);
            if(n.left != null) st.push(n.left);
        }
        
        return rst;
    }
}