public class Solution {
    public int trap(int[] height) {
        if(height == null || height.length <= 2){
        	return 0;
        }
        int lmax = 0;
        int[] l = new int[height.length];
        for(int i=0;i<height.length;i++){
        	l[i] = lmax;
        	if(height[i] > lmax){
        		lmax = height[i];
        	}
        }
        
        int rmax = 0;
        int[] r = new int[height.length];
        for(int i=height.length-1;i>=0;i--){
        	r[i] = rmax;
        	if(height[i] > rmax){
        		rmax = height[i];
        	}
        }
        
        int rst = 0;
        for(int i=0;i<height.length;i++){
        	int volumn = Math.min(l[i], r[i]) - height[i];
        	rst += volumn > 0 ? volumn : 0;
        }
        return rst;
    }
}