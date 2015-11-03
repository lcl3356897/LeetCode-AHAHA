public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode rst = new ListNode(0);
        rst.next = head;
     
        ListNode p = rst;
        while(p.next!=null&&p.next.next!=null){
            if(p.next.val == p.next.next.val){
                int dup = p.next.val;
                while(p.next!=null&&p.next.val==dup){
                    p.next = p.next.next;
                }
            }else{
                p=p.next;
            }
        }
        return rst.next;
    }
}

//
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode rst = new ListNode(0);
        rst.next = head;
     
        ListNode p = rst;
        while(p.next!=null && p.next.next!=null){
            if(p.next.val == p.next.next.val){
                while(p.next.next != null && p.next.val == p.next.next.val){
                    p.next.next = p.next.next.next;
                }
                p.next = p.next.next;
            }
            else{
                p = p.next;
            }
        }
        return rst.next;
    }
}