public class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        if(intervals == null || intervals.length == 0) return true;
        
        class intervalSort implements Comparator<Interval>{
        	public int compare(Interval i1, Interval i2){
        		return i1.start - i2.start;
        	}
        }
        Arrays.sort(intervals, new intervalSort());
        
        for(int i = 1; i < intervals.length; i++){
        	if(intervals[i].start < intervals[i-1].end){
        		return false;
        	}
        }
        
        return true;
    }
}


//BitMap

public class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        BitSet bs = new BitSet();
        for(Interval interval: intervals) {
            for(int i = interval.start; i< interval.end; i++) {
                if(bs.get(i)) return false;
                bs.set(i, true);
            }
        }
        return true;
    }
}