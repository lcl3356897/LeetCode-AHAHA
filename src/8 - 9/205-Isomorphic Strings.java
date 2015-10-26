public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s == null || t == null || s.length() != t.length()){
        	return false;
        }
        HashMap<Character, Character> hm = new HashMap<Character, Character>();
        for(int i=0;i<s.length();i++){
        	if(hm.containsKey(s.charAt(i))){
        		if(t.charAt(i) != hm.get(s.charAt(i))){
        			return false;
        		}
        	}
        	else if(hm.containsValue(t.charAt(i))){
        		return false;
        	}
        	else{
        		hm.put(s.charAt(i), t.charAt(i));
        	}
        }
        return true;
    }
}