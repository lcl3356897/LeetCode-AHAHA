public class Solution {
    public int largestRectangleArea(int[] height) {
        if(height == null || height.length <= 0){
            return 0;
        } 
        Stack<Integer> st = new Stack<Integer>();
        int[] h = Arrays.copyOf(height, height.length + 1);
        int rst = 0;
        for(int i=0;i<h.length;){
            if(st.empty() || h[i] >= h[st.peek()]){
                st.push(i++);
            }
            else{
                int tmp = st.pop();
                rst = Math.max(rst, h[tmp] * (st.empty() ? i : i-st.peek()-1));
            }
        }
        return rst;
        
    }
}