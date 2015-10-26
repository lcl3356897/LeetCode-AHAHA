public class Solution {
    public int titleToNumber(String s) {
        if(s == null || s.length() == 0){
        	return 0;
        }
        int rst = 0;
        for(int i=0;i<s.length();i++){
        	rst += (s.charAt(i) - 'A' + 1) * Math.pow(26, s.length()-1-i);
        }
        return rst;
    }
}