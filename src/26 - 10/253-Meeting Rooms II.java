public class Solution {
	public int minMeetingRooms(Interval[] intervals) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		if(intervals == null || intervals.length == 0) return 0;
        
        class intervalSort implements Comparator<Interval>{
        	public int compare(Interval i1, Interval i2){
        		return i1.start - i2.start;
        	}
        }
        Arrays.sort(intervals, new intervalSort());
        
        for(int i = 0; i < intervals.length; i++){
        	if(!pq.isEmpty() && intervals[i].start >= pq.peek()){
        		pq.poll();
        	}
        	pq.add(intervals[i].end);
        }
        
        return pq.size();
    }
}