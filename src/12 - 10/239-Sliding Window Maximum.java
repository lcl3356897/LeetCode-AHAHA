//PriorityQueue  Heap
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return new int[0];
        }       
        int[] rst = new int[nums.length - k + 1];
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int i=0;i<k;i++){
            pq.add(nums[i]);
        }
        rst[0] = pq.peek();
        for(int i=k;i<nums.length;i++){
            pq.remove(nums[i - k]);
            pq.add(nums[i]);
            rst[i - k + 1] = pq.peek();
        }
        return rst;
    }
}

//Deque

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] rst = new int[0];
        if(nums == null || nums.length == 0 || (nums.length < k)){
            return rst;
        }
        rst = new int[nums.length - k + 1];
        Deque<Integer> dq = new LinkedList<Integer>();
        for(int i=0;i<k;i++){
            while(dq.isEmpty() == false && nums[i] > nums[dq.peekLast()]){
                dq.removeLast();
            }
            dq.add(i);
        }
        rst[0] = nums[dq.peekFirst()];
        for(int i=k;i<nums.length;i++){
            while(dq.isEmpty() == false && dq.peekFirst() < (i-k+1)){
                dq.removeFirst();
            }
            while(dq.isEmpty() == false && nums[i] > nums[dq.peekLast()]){
                dq.removeLast();
            }
            dq.addLast(i);
            rst[i-k+1] = nums[dq.peekFirst()];
        }
        return rst;
    }
}
