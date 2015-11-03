//Use Circle
public class Solution {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA == null || headB == null){
			return null;
		}
		ListNode p = headA;
		while(p.next != null){
			 p = p.next;
		}
		p.next = headB;
		ListNode rst = detectCycle(headA);
		p.next = null;
		return rst;
    }
	
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
        	slow = slow.next;
        	fast = fast.next.next;
        	if(slow == fast){
        		slow = head;
        		while(slow != fast){
        			slow = slow.next;
        			fast = fast.next;
        		}
        		return slow;
        	}
        }
        return null;
    }
}

//Use Diff
public class Solution {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA == null || headB == null){
			return null;
		}
		ListNode pa = headA;int na = 0;
		ListNode pb = headB;int nb = 0;
		while(pa != null){
			pa = pa.next;
			na++;
		}
		while(pb != null){
			pb = pb.next;
			nb++;
		}
		pa = headA; pb = headB;
		boolean startA = false;
		int diff = 0;
		if(na > nb){
			startA = true;
			diff = na - nb;
		} 
		else{
			diff = nb - na;
		}
		if(startA){
			while(diff-->0){
				pa = pa.next;
			}
		}
		else{
			while(diff-->0){
				pb = pb.next;
			}
		}
		while(pa != pb){
			pa = pa.next;
			pb = pb.next;
		}
		return pa;
    }
}