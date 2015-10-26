public class Solution {
    public String convertToTitle(int n) {
        if(n <= 0){
            return "";
        }
        StringBuffer rst = new StringBuffer();
        while(n > 0){
            rst.append((char)('A' + (n-1) % 26));
            n = (n-1) / 26;
        }
        return rst.reverse().toString();
    }
}