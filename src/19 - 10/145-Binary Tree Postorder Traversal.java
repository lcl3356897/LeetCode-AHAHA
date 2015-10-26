public class Solution {
	List<Integer> rst = new ArrayList<Integer>();
	
    public List<Integer> postorderTraversal(TreeNode root) {
    	if(root == null) return rst;
    	postorder(root);
    	return rst;
    }
    
    private void postorder(TreeNode root){
    	if(root.left != null) postorder(root.left);
    	if(root.right != null) postorder(root.right);
    	rst.add(root.val);
    }
}

//

public class Solution {
    ArrayList<Integer> rst = new ArrayList<Integer>();
    
    public List<Integer> postorderTraversal(TreeNode root) {
 
 
        if(root == null)
            return rst; 
 
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
 
        TreeNode prev = null;
        while(!stack.empty()){
            TreeNode cur = stack.peek();

            // go down the tree.
            //check if current node is leaf, if so, process it and pop stack,
            //otherwise, keep going down
            if(prev == null || prev.left == cur || prev.right == cur){
                //prev == null is the situation for the root node
                if(cur.left != null){
                    stack.push(cur.left);
                }else if(cur.right != null){
                    stack.push(cur.right);
                }else{
                    stack.pop();
                    rst.add(cur.val);
                }
 
            //go up the tree from left node    
            //need to check if there is a right child
            //if yes, push it to stack
            //otherwise, process parent and pop stack
            }else if(cur.left == prev){
                if(cur.right != null){
                    stack.push(cur.right);
                }else{
                    stack.pop();
                    rst.add(cur.val);
                }
 
            //go up the tree from right node 
            //after coming back from right node, process parent node and pop stack. 
            }else if(cur.right == prev){
                stack.pop();
                rst.add(cur.val);
            }
 
            prev = cur;
        }
 
        return rst;
    }
}