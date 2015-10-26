public class Solution {
	public boolean isOneEditDistance(String s, String t) {
		if(Math.abs(s.length() - t.length()) > 1) return false;
		
		if(s.length() > t.length()){
			String tmp = t;
			t = s; s = tmp;
		}
		
		boolean diff = false;
		for(int i = 0, j = 0; i < s.length(); i++, j++){
			if(s.charAt(i) != t.charAt(j)){
				if(diff) return false;
				diff = true;
				if(s.length() != t.length()){// try insert a char
					i--;
				}
			}
		}
		
		return diff || s.length() != t.length();
    }
}