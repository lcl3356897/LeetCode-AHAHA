public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    	List<List<Integer>> rst = new ArrayList<List<Integer>>();
    	
        if(root == null) return rst;
        
        Stack<TreeNode> cur = new Stack<TreeNode>();
        Stack<TreeNode> next = new Stack<TreeNode>();
        cur.add(root);
        
        boolean normal = true;
        while(!cur.isEmpty()){
        	List<Integer> curRst = new ArrayList<Integer>();
        	while(!cur.isEmpty()){
        		TreeNode now = cur.pop();
        		curRst.add(now.val);
        		
        		if(normal){
        			if(now.left != null) next.add(now.left);
        			if(now.right != null) next.add(now.right);
        		}
        		else{
        			if(now.right != null) next.add(now.right);
        			if(now.left != null) next.add(now.left);
        		}
        	}
        	
        	rst.add(curRst);
        	cur = next;
        	next = new Stack<TreeNode>();
        	
        	normal = !normal;
        }
        
        return rst;
    }
}