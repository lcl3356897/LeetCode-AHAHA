public class Solution {
    public int myAtoi(String str) {
        if(str == null) return 0;
        str = str.trim();
        if(str.length() == 0) return 0;

        int i = 0; 
        
        boolean neg = false;
        if(str.charAt(i) == '+' || str.charAt(i) == '-'){
            neg = str.charAt(i) == '-';
            i++;
        }
    
        int rst = 0, limit = Integer.MAX_VALUE / 10;        
        for(; i < str.length(); i++){
            char c = str.charAt(i);
            if(!Character.isDigit(c)) break;
            int num = c - '0';
            if(neg){
                if((rst > limit) || (rst == limit && num >= 8)){
                    return Integer.MIN_VALUE;
                }
            }
            else{
                if((rst > limit) || (rst == limit && num >= 7)){
                    return Integer.MAX_VALUE;
                }
            }
            rst = rst * 10 + num;
        }

        return !neg ? rst : -rst;
    }
}