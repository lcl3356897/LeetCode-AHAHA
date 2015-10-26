public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        return build(head, null);
    }
    
    private TreeNode build(ListNode start, ListNode end){
    	if(start == end) return null;
    	
    	ListNode mid = start, l2 = start;
    	while(l2 != end && l2.next != end){
    		mid = mid.next;
    		l2 = l2.next.next;
    	}
    	
    	TreeNode root = new TreeNode(mid.val);
    	root.left = build(start, mid);
    	root.right = build(mid.next, end);
    	return root;
    }
}