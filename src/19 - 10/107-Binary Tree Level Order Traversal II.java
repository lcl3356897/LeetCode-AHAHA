public class Solution {
	List<List<Integer>> rst = new ArrayList<List<Integer>>();
	
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null) return rst;
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty()){
        	List<Integer> cur = new ArrayList<Integer>();
        	int len = q.size();
        	for(int i=0;i<len;i++){
        		TreeNode tmp = q.poll();
        		cur.add(tmp.val);
        		if(tmp.left != null) q.add(tmp.left);
        		if(tmp.right != null) q.add(tmp.right);
        	}
        	rst.add(0, cur);
        }
        return rst;
    }
}