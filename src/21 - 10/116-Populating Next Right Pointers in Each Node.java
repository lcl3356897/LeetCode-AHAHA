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
        if(root == null) return;
          
        // 左节点非空，连接右节点  
        if(root.left != null){  
            root.left.next = root.right;  
        }
        /*  
            1 -> NULL 
          /  \ 
         2 -> 3 -> NULL 
        / \  / \ 
       4->5->6->7 -> NULL
        */ 
        // 借助root.next处理5连6的情况  
        if(root.right!=null && root.next!=null){  
            root.right.next = root.next.left;  
        }  
          
        connect(root.left);  
        connect(root.right);  
    }
}