//Iteration
public class Solution {
	List<Integer> rst = new ArrayList<Integer>();
	
    public List<Integer> inorderTraversal(TreeNode root) {
    	if(root == null) return rst;
    	inorder(root);
    	return rst;
    }
    
    private void inorder(TreeNode root){
    	if(root.left != null) inorder(root.left);
    	rst.add(root.val);
    	if(root.right != null) inorder(root.right);
    }
}


//Recursion

public class Solution {
	List<Integer> rst = new ArrayList<Integer>();
	
	public List<Integer> inorderTraversal(TreeNode root) {
		Stack<TreeNode> st = new Stack<TreeNode>();
		
		TreeNode p = root;
		
		while(!st.empty() || p != null){
            if(p != null){
                st.push(p);
                p = p.left;
            }else{
                TreeNode t = st.pop();
                rst.add(t.val);
                p = t.right;
            }
        }
		
		return rst;
    }
}