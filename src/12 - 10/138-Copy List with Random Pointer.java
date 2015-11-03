public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
    	if(head == null){
    		return null;
    	}
    	//Insert
        RandomListNode cur = head;
        while(cur != null){
        	RandomListNode tmp = new RandomListNode(cur.label);
        	tmp.next = cur.next;
        	cur.next = tmp;
        	cur = tmp.next;
        }
        //Copy Random Pointer
        cur = head;
        while(cur != null){
        	RandomListNode tmp = cur.next;
        	if(cur.random != null){
        		tmp.random = cur.random.next;
        	}
        	cur = tmp.next;
        }
        
        //Seperate Two Links
        cur = head;
        RandomListNode rst = head.next;
        while(cur != null){
        	RandomListNode tmp = cur.next;
        	cur.next = tmp.next;
        	if(tmp.next != null){
        		tmp.next = tmp.next.next;
        	}
        	cur = cur.next;
        }
        return rst;
    }
}