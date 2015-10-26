public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode rst = new ListNode(-1);rst.next = head;
        ListNode now = rst.next, run = now.next;
        while(run != null){
            if(run.val != now.val){
                now.next = run;
                now = now.next;
            }
            run = run.next;
        }
        now.next = null;
        return rst.next;
    }
}

//

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
    	if(head == null){
        	return null;
        }
    	ListNode rst = new ListNode(-1);rst.next = head;
    	ListNode cur = rst.next, tmp = rst.next.next;
    	while(tmp != null){
    		if(tmp.val == cur.val){
    			tmp = tmp.next;
    			cur.next = tmp;
    		}
    		else{
    			cur = tmp;
    			tmp = tmp.next;
    		}
    	}
    	return rst.next;
    }
}