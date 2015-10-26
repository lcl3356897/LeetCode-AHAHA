public class Solution {
    public boolean wordPattern(String pattern, String str) {
        if(pattern == null || pattern.length() == 0) return false;
        if(str == null || str.length() == 0) return false;

        String[] s = str.split(" ");
        if(pattern.length() != s.length) return false;
        
        HashMap<Character, String> hm = new HashMap<Character, String>();
        
        for(int i=0;i<pattern.length();i++){
        	char c = pattern.charAt(i);
        	if(hm.containsKey(c)){
        		if(!s[i].equals(hm.get(c))) return false;
        	}
        	else{
        		if(hm.containsValue(s[i])) return false;
        		hm.put(c, s[i]);
        	}
        }
        return true;
    }
}