public class Solution {
    public boolean isAnagram(String s, String t) {
        if(s == null || t == null){
        	return false;
        }
        HashMap<Character, Integer> hs = new HashMap<Character, Integer>();
        for(int i=0;i<s.length();i++){
        	if(hs.containsKey(s.charAt(i))){
        		hs.put(s.charAt(i), hs.get(s.charAt(i)) + 1);
        	}
        	else{
        		hs.put(s.charAt(i), 1);
        	}
        }
        for(int i=0;i<t.length();i++){
        	if(!hs.containsKey(t.charAt(i)) || hs.get(t.charAt(i)) == 0){
        		return false;
        	}
        	hs.put(t.charAt(i), hs.get(t.charAt(i)) - 1);
        	if(hs.get(t.charAt(i)) == 0){
        		hs.remove(t.charAt(i));
        	}
        }
        return hs.isEmpty();
    }
}

//Array
public class Solution {
    public boolean isAnagram(String s, String t) {
        if(s == null || t == null || s.length() != t.length()){
            return false;
        }
        int[] times = new int[26];
        for(int i=0;i<s.length();i++){
            times[s.charAt(i) - 'a']++;
            times[t.charAt(i) - 'a']--;
        }
        for(int i=0;i<26;i++){
            if(times[i]!=0){
                return false;
            }
        }
        return true;
    }
}