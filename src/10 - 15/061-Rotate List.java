public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode rst = new ListNode(-1);rst.next = head;
        int len = 0;ListNode tmp = rst;
        while(tmp.next != null){
        	tmp = tmp.next;
        	len++;
        }
        if(len == 0){
        	return null;
        }
        k = k % len;
        ListNode p1 = rst, p2 = rst;
        while(k-- > 0){
        	p2 = p2.next;
        }
        while(p2.next != null){
        	p1 = p1.next;
        	p2 = p2.next;
        }
        p2.next = rst.next;
        rst.next = p1.next;
        p1.next = null;
        return rst.next;
    }
}