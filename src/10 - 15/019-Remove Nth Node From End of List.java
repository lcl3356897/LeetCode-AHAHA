public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            return null;
        }
        ListNode rst = new ListNode(-1);rst.next = head;
        ListNode l1 = rst; ListNode l2 = rst;
        while(n-- > 0 ){
            l2 = l2.next;
        } 
        while(l2.next != null){
            l1=l1.next;l2=l2.next;
        }
        l1.next = l1.next.next;
        return rst.next;
    }
}