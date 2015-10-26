public class Solution {
    public int maxArea(int[] height) {
        if(height == null || height.length <= 0){
            return 0;
        }   
        int rst = 0;
        int left = 0, right = height.length - 1;
        while(left < right){
            rst = Math.max(rst, (right - left) * Math.min(height[left], height[right]));
            if(height[left] < height[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return rst;
    }
}