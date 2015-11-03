public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode rst = new ListNode(-1); rst.next = head;
        ListNode run = rst;
        while(run.next != null && run.next.next != null){
            ListNode next = run.next.next;
            run.next.next = next.next;
            next.next = run.next;
            run.next = next;
        }   
        return rst.next;
    }
}