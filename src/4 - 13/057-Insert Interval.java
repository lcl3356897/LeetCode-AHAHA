public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
 		if(intervals == null){
 			return intervals;
 		}       
 		intervals.add(newInterval);
 		class compare implements Comparator<Interval>{
 			public int compare(Interval o1, Interval o2){
 				return o1.start - o2.start;
 			}
 		}
 		Collections.sort(intervals, new compare());
 		for(int i=1;i<intervals.size();i++){
 			if(intervals.get(i).start <= intervals.get(i-1).end){
 				Interval tmp = new Interval(intervals.get(i-1).start, Math.max(intervals.get(i-1).end, intervals.get(i).end));
 				intervals.remove(i-1);intervals.remove(i-1);
 				intervals.add(i-1, tmp);
 				i--;
 			}
 		}
 		return intervals;
    }
}