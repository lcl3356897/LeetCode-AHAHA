public class Solution {
	Map<Character, String> hm = new HashMap<Character, String>();
	
    public boolean wordPatternMatch(String pattern, String str) {
        return match(pattern, 0, str, 0);
    }
    
    private boolean match(String pat, int p, String str, int s){
    	if(p == pat.length() && s == str.length()) return true;
    	if(p == pat.length() || s == str.length()) return false;
    	
    	char c = pat.charAt(p);
    	if(hm.containsKey(c)){
    		String pair = hm.get(c);
    		if(!str.startsWith(pair, s)){
    			return false;
    		}
    		
    		return match(pat, p+1, str, s+pair.length());
    	}
    	
    	for(int i = s; i < str.length(); i++){
    		String pair = str.substring(s, i + 1);
    		if(hm.containsValue(pair)) continue;
    		hm.put(c, pair);
    		if(match(pat, p+1, str, i+1)) return true;
    		hm.remove(c);
    	}
    	
    	return false;
    }
}