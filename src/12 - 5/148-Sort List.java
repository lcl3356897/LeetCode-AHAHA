public class Solution {
	public ListNode sortList(ListNode head) {
		if(head == null){
			return null;
		}
		return MergeSortList(head);
    }
	
	public ListNode MergeSortList(ListNode head){
		if(head == null || head.next == null){
			return head;
		}
		ListNode rst = new ListNode(-1);rst.next = head;
		ListNode first = rst, second = rst;
		while(second != null && second.next != null){
			second = second.next.next;
			first = first.next;
		}
		second = first.next;
		first.next = null;
		first = rst.next;
		first = MergeSortList(first);
		second = MergeSortList(second);
		return mergeTwoLists(first, second);
	}
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode rst = new ListNode(-1);
        ListNode tmp = rst;
        while(l1!=null && l2!=null){
            if(l1.val < l2.val){
                tmp.next = l1;
                l1 = l1.next;
            }
            else{
                tmp.next = l2;
                l2=l2.next;
            }
            tmp = tmp.next;
        }
        if(l1!=null){
            tmp.next = l1;
        }
        if(l2!=null){
            tmp.next = l2;
        }
        return rst.next;
    }
}