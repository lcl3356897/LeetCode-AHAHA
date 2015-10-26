public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode rst = new ListNode(-1);rst.next = head;
        ListNode t = rst;
        while(t.next!=null){
        	if(t.next.val == val){
        		t.next = t.next.next;
        	}
        	else{
            	t = t.next;
        	}
        }
        return rst.next;
    }
}