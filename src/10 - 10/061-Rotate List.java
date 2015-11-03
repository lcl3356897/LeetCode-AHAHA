public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode rst = new ListNode(-1); rst.next = head;
        ListNode l1 = rst, l2 = rst;
        int len = 0;
        while(l2.next != null){
            l2 = l2.next;
            len++;
        }
        if(len == 0) return rst.next;
        k = k % len;
        l2 = rst;
        while(k-- > 0){
            l2 = l2.next;
        }
        while(l2.next != null){
            l1 = l1.next;
            l2 = l2.next;
        }
        l2.next = rst.next;
        rst.next = l1.next;
        l1.next = null;
        return rst.next;
    }
}