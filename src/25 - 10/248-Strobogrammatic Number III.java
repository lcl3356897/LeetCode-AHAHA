public class Solution {
	HashMap<Character, Character> hm = new HashMap<Character, Character>();
	int rst = 0;
	
    public int strobogrammaticInRange(String low, String high) {
        if(low == null || low.length() == 0 || high == null || high.length() == 0) return rst;
        
        hm.put('0', '0'); hm.put('1', '1'); hm.put('8', '8'); hm.put('6', '9'); hm.put('9', '6');
        
        for(int i = low.length(); i <= high.length(); i++){
        	char[] arr = new char[i];
        	helper(arr, 0, i - 1, low, high);
        }
        
        return rst;
    }
    
    private void helper(char[] arr, int start, int end, String low, String high){
    	if(start > end){
    		String s = new String(arr);
            if ((s.length() == 1 || s.charAt(0) != '0') && compare(low, s) && compare(s, high)) {
                rst++;
            }
            return;
    	}
    	
        for(char c : hm.keySet()){
        	arr[start] = c;
        	arr[end] = hm.get(c);
        	
        	if ((start < end) || (start == end && hm.get(c) == c)) {
        		helper(arr, start + 1, end - 1, low, high);
            }
        }
    }
    
    //Return true if s1 <= s2
    private boolean compare(String s1, String s2) {
        if (s1.length() == s2.length()) {
            if (s1.compareTo(s2) <= 0) {
                return true;
            } else {
                return false;
            }
        }
         
        return true;
    }
}