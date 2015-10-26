//Binary Search
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int leftCount = count(root.left) + 1;
        if(leftCount == k){
        	return root.val;
        }
        else if(leftCount > k){
        	return kthSmallest(root.left, k);
        }
        else{
        	return kthSmallest(root.right, k - leftCount);
        }
    }
    
    public int count(TreeNode root){
    	if(root == null) return 0;
    	return count(root.left) + count(root.right) + 1;
    }
}

//InOrder
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
     
        TreeNode p = root;
        int result = 0;
     
        while(!stack.isEmpty() || p != null){
            if(p != null){
                stack.push(p);
                p = p.left;
            }else{
                TreeNode t = stack.pop();
                k--;
                if(k == 0) result = t.val;
                p = t.right;
            }
        }
     
        return result;
    }
}