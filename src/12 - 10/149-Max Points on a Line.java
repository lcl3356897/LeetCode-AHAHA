public class Solution {
    public int maxPoints(Point[] points) {
        int rst = 0;
        for(int i=0;i<points.length;i++){
        	HashMap<Double, Integer> hm = new HashMap<Double, Integer>();
        	hm.put(Double.MAX_VALUE, 0);
        	int dup = 1;
        	for(int j=i+1;j<points.length;j++){
        		if(points[j].x == points[i].x && points[j].y == points[i].y){
        			dup++;
        			continue;
        		}
        		double slope = (points[j].x - points[i].x == 0) ? Double.MAX_VALUE 
        					: (double)(points[j].y - points[i].y) / (points[j].x - points[i].x);
        		slope = slope == -0.0 ? 0.0 : slope;
        		if(hm.containsKey(slope)){
        			hm.put(slope, hm.get(slope) + 1);
        		}
        		else{
        			hm.put(slope, 1);
        		}
        	}
        	for(int value : hm.values()){
        		rst = Math.max(rst, value+dup);
        	}
        }
        return rst;
   }  
}