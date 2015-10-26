public class Solution {
	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode rst = new ListNode(-1);rst.next = head;
		ListNode l1 = rst, l2 = rst;
		while(l2 != null && l2.next != null){
			int tmp = k;
			l2 = l1;
			while(tmp-- > 0 && l2 != null){
				l2 = l2.next;
			}
			if(l2 == null) break;
			l1.next = reverseList(l1.next, l2);
			tmp = k;
			while(tmp-->0){
				l1 = l1.next;
			}
		}
		return rst.next;
	}
		
	public ListNode reverseList(ListNode head, ListNode end) {
        if(head == null){
        	return null;
        }
        ListNode rst = new ListNode(-1);rst.next = head;
        ListNode cur= rst.next;
        while(rst.next != end){
        	ListNode next = cur.next;
        	cur.next = next.next;
        	next.next = rst.next;
        	rst.next = next;
        }
        return rst.next;
    }
}