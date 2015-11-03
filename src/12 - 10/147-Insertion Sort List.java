public class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode rst = new ListNode(-1);
        while(head != null){
            ListNode t = rst;
            while(t.next != null && t.next.val < head.val){
                t = t.next;
            }
            ListNode next = head.next;
            head.next = t.next;
            t.next = head;
            head = next;
        }
        return rst.next;
    }
}