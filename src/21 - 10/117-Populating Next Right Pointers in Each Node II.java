//Recursively
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        Queue<TreeLinkNode> q = new LinkedList<TreeLinkNode>();
        q.add(root);
        while(!q.isEmpty()){
        	int len = q.size();
        	while(len-- > 0){
        		TreeLinkNode tmp = q.poll();
        		tmp.next = len == 0 ? null : q.peek();
        		if(tmp.left != null) q.add(tmp.left);
        		if(tmp.right != null) q.add(tmp.right);
        	}
        }
    }
}

//

public class Solution {
    public void connect(TreeLinkNode root) {
        // 空节点就直接返回  
        if(root == null || (root.left == null && root.right == null)) return;
        
        TreeLinkNode next = root.next;
        while(next != null && (next.left == null && next.right == null)){
            next = next.next;
        } 
        
        if(root.left != null){
            root.left.next = root.right != null ? root.right : next == null ? null : next.left != null ? next.left : next.right;
        }
        
        if(root.right != null){
            root.right.next = next == null ? null : next.left != null ? next.left : next.right;
        }
        

        connect(root.right);  
        connect(root.left);  
    }
}