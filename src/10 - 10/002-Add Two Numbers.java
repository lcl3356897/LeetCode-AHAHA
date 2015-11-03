public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode rst = new ListNode(-1);
        ListNode run = rst;
        int carry = 0;
        while(l1 != null || l2 != null){
            if(l1 != null){
                carry += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                carry += l2.val;
                l2 = l2.next;
            }
            run.next = new ListNode(carry % 10);
            run = run.next;
            carry /= 10;
        }
        if(carry != 0){
            run.next = new ListNode(carry % 10);
        }
        return rst.next;
    }
}