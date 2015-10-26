public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
        	return head;
        }
        ListNode rst = new ListNode(-1);rst.next = head;
        ListNode tmp = rst;
        while(tmp.next != null && tmp.next.next != null){
        	ListNode t1 = tmp.next;
        	ListNode t2 = tmp.next.next;
        	tmp.next = t2;
        	t1.next = t2.next;
        	t2.next = t1;
        	tmp = tmp.next.next;
        }
        return rst.next;
    }
}