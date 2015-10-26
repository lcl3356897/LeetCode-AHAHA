public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode rst = new ListNode(-1);
        if(lists == null || lists.length == 0){
            return rst.next;
        }
        ListNode tmp = rst;
        class ListNodeCompare implements Comparator<ListNode>{
        	public int compare(ListNode o1, ListNode o2){
        		return o1.val - o2.val;
        	}
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(new ListNodeCompare());
        for(int i=0;i<lists.length;i++){
        	if(lists[i] != null){
        		pq.add(lists[i]);
        	}
        }
        while(pq.isEmpty() == false){
        	tmp.next = pq.poll();
        	tmp = tmp.next;
        	if(tmp.next != null){
        		pq.add(tmp.next);
        	}
        }
        return rst.next;
    }
}

//二分法

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if(n == 0) return null;
        while(n > 1)
        {
            int k = (n+1)/2;
            for(int i = 0; i < n/2; i++)
                lists[i] = mergeTwoLists(lists[i], lists[i + k]);
            n = k;
        }
        return lists[0];
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode rst = new ListNode(-1);
        ListNode tmp = rst;
        while(l1!=null && l2!=null){
            if(l1.val <= l2.val){
                tmp.next = l1;
                l1 = l1.next;
            }
            else{
                tmp.next = l2;
                l2 = l2.next;
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