public class Solution {
    public int titleToNumber(String s) {
        if(s == null || s.length() == 0) return 0;
        int rst = 0, scale = 1;
        for(int i = s.length() - 1; i >= 0; i--){
            rst += (s.charAt(i) - 'A' + 1) * scale;
            scale *= 26;
        }
        return rst;
    }
}