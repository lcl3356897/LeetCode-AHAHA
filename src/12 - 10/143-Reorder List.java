public class Solution {
	public void reorderList(ListNode head) {
        if(head==null || head.next == null){
            return;
        }
        ListNode rst = new ListNode(-1);rst.next = head;
        ListNode l1 = rst, l2 = rst;
        while(l2 != null && l2.next != null){
            l1 = l1.next;
            l2 = l2.next.next;
        }
        l2 = reverseList(l1.next);
        l1.next = null;
        l1 = rst.next;
        while(l1 != null && l2 != null){
        	ListNode tmp = l2.next;
        	l2.next = l1.next;
        	l1.next = l2;
        	l2 = tmp;
        	l1 = l1.next.next;
        }
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