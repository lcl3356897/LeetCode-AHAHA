public class Solution {
    public void reverseWords(char[] s) {
    	reverse(s, 0, s.length - 1);
    	for(int i = 0, j = 0; j <= s.length; j++){
    		if(j == s.length || s[j] == ' '){
    			reverse(s, i, j - 1);
    			i = j + 1;
    		}
    	}
    }
    
    private void reverse(char[] s, int start, int end){
    	while(start < end){
    		char t = s[start];
    		s[start++] = s[end];
    		s[end--] = t;
    	}
    }
}