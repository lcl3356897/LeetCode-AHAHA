public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode rst = new ListNode(-1), run = rst;

        class ListNodeCompare implements Comparator<ListNode>{
            public int compare(ListNode l1, ListNode l2){
                return l1.val - l2.val;
            }
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(new ListNodeCompare());
        for(ListNode node : lists){
            if(node != null) pq.add(node);
        }
        while(!pq.isEmpty()){
            ListNode node = pq.poll();
            run.next = node; 
            run = run.next;
            if(node.next != null) pq.add(node.next);
        }
        return rst.next;
    }
}

//二分法

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        int n = lists.length;
        while(n > 1){
            int k = (n + 1) / 2;
            for(int i = 0; i < n / 2; i++){
                lists[i] = mergeTwoLists(lists[i], lists[i + k]);
            }
            n = k;
        }
        return lists[0];
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode rst = new ListNode(-1);
        ListNode run = rst;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                run.next = l1;
                l1 = l1.next;
            }
            else{
                run.next = l2;
                l2 = l2.next;
            }
            run = run.next;
        }
        if(l1 != null) run.next = l1;
        if(l2 != null) run.next = l2;

        return rst.next;
    }
}