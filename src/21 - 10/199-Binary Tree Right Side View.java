public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rst = new ArrayList<Integer>();
        if(root == null) return rst;
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty()){
        	int len = q.size();
    		rst.add(q.peek().val);
        	while(len-- > 0){
        		TreeNode tmp = q.poll();
        		if(tmp.right != null) q.add(tmp.right);
        		if(tmp.left != null) q.add(tmp.left);
        	}
        }
        
        return rst;
    }
}