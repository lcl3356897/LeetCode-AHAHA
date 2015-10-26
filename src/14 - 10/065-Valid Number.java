public class Solution {
    public boolean isNumber(String s) {
    	if(s == null){ return false; }
        s = s.trim();// skip whitespace
        if(s.length() == 0) {return false;} 
        
        int i = 0;
        // skip leading +/-
        if (s.charAt(i) == '+' || s.charAt(i) == '-') i++;
        boolean num = false; // is a digit
        boolean dot = false; // is a '.'
        boolean e = false; // is a 'e'
        while (i < s.length()) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {//'0' <= c || c <= '9'
                num = true;
            }
            else if (c == '.') {
                if(e || dot) return false;
                dot = true;
            }
            else if (c == 'e') {
                if(e || num == false) return false;
                e = true;
                num = false;
            }
            else if (c == '+' || c == '-') {
                if (s.charAt(i - 1) != 'e') return false;
            }
            else {
                return false;
            }
            i++;
        }
        return num;
    }
}