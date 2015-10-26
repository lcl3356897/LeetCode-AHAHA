public class Solution {
	public boolean isMatch(String s, String p) {
		int si = 0, pi = 0;
		int starIndex = -1, sIndex = -1;
		while(si < s.length()){
			if(pi < p.length() && (p.charAt(pi) == s.charAt(si) || p.charAt(pi) == '?')){
				si++;pi++;
			}
			else if(pi < p.length() && p.charAt(pi) == '*'){
				starIndex = pi;
				sIndex = si;
				pi++;
			}
			else if(starIndex != -1){
				pi = starIndex + 1;
				si = sIndex + 1;
				sIndex++;
			}
			else{
				return false;
			}
		}
		while(pi < p.length() && p.charAt(pi) == '*') pi++;
		return pi == p.length();
	}
}

//DP
public class Solution {
	public boolean isMatch(String s, String p) {
	    if(p.length() == 0) return s.length()==0;
	    boolean[] res = new boolean[s.length()+1];
	    res[0] = true;
	    for(int j = 0; j < p.length(); j++){
	        if(p.charAt(j)!='*'){
	            for(int i = s.length() - 1; i >= 0; i--){
	                res[i+1] = res[i] && (p.charAt(j)=='?' || s.charAt(i) == p.charAt(j));
	            }
	        }
	        else{
	            int i = 0;
	            while(i <= s.length() && !res[i]) i++;
	            for(; i <= s.length(); i++){
	                res[i] = true;
	            }
	        }
	        res[0] = res[0] && p.charAt(j)=='*';
	    }
	    return res[s.length()];
	}
}