public class Solution {
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

//Recursively

public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next == null)
            return head;
     
        //get second node    
        ListNode second = head.next;
        //set first's next to be null
        head.next = null;
     
        ListNode rest = reverseList(second);
        second.next = head;
     
        return rest;
    }
}