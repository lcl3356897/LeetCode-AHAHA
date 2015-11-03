public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode rst = new ListNode(-1);rst.next = head;
        ListNode p1 = rst, p2 = rst;
        while(m-->1){
            p1 = p1.next;
        }
        while(n-->1){
            p2 = p2.next;
        }
        p1.next = reverseList(p1.next, p2.next);
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