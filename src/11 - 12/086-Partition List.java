public class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head == null){
            return head;
        }       
        ListNode t1 = new ListNode(-1), t2 = new ListNode(-1);
        ListNode p1 = t1, p2 = t2;
        ListNode run = rst.next;
        while(run != null){
            if(run.val < x){
                p1.next = run;
                p1 = p1.next;
            }
            else{
                p2.next = run;
                p2 = p2.next;
            }
            run = run.next;
        }
        p1.next = t2.next;
        p2.next = null;
        return t1.next;
    }
}