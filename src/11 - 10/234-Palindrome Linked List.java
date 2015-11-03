public class Solution {
	public boolean isPalindrome(ListNode head) {
		if(head==null || head.next == null){
            return true;
        }
		ListNode rst = new ListNode(-1);rst.next = head;
		ListNode l1 = rst, l2 = rst;
		while(l2!=null && l2.next!=null){
			l1 = l1.next;
			l2 = l2.next.next;
		}
		l2 = rst;
		l1.next = reverseList(l1.next);
		while(l1.next!=null){
			if(l1.next.val != l2.next.val){
				return false;
			}
			l1 = l1.next;
			l2 = l2.next;
		}
		return true;
    }
	
	public ListNode reverseList(ListNode head) {
        if(head == null){
        	return null;
        }
        ListNode rst = new ListNode(-1);rst.next = head;
        ListNode cur= rst.next;
        while(cur.next != null){
        	ListNode next = cur.next;
        	cur.next = next.next;
        	next.next = rst.next;
        	rst.next = next;
        }
        return rst.next;
    }
}