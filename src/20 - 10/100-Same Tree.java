//Recursively

public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if((p == null) ^ (q == null)) return false;
        if(p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

//Iteratively

public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> q1 = new LinkedList<TreeNode>(),
        				q2 = new LinkedList<TreeNode>();
        q1.add(p);q2.add(q);
        while(!q1.isEmpty() && !q2.isEmpty()){
        	TreeNode t1 = q1.poll();
        	TreeNode t2 = q2.poll();
        	if(t1 == null && t2 == null) continue;
        	if((t1 == null ^ (t2 == null))) return false;
        	if(t1.val != t2.val) return false;
        	q1.add(t1.left);q1.add(t1.right);
        	q2.add(t2.left);q2.add(t2.right);
        }
        return q1.isEmpty() && q2.isEmpty();
    }
}