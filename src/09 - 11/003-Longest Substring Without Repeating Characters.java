//HashMap
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
        	return 0;
        }
        int start=0,rst=0;
        HashMap<Character, Boolean> used = new HashMap<Character, Boolean>();
        //boolean[] used = new boolean[26];
        for(int i=0;i<s.length();i++){
        	if(used.containsKey(s.charAt(i)) && used.get(s.charAt(i))){
            	while(s.charAt(start) != s.charAt(i)){
            		used.put(s.charAt(start), false);
            		start++;
            	}
            	start++;
        	}
        	else{
        		used.put(s.charAt(i), true);
        	}
        	rst = Math.max(rst, i - start+1);
        }
        return rst;
    }
}

//Array
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int start=0,rst=0;
        boolean[] used = new boolean[256];
        for(int i=0;i<s.length();i++){
            if(used[s.charAt(i)]){
                while(s.charAt(start) != s.charAt(i)){
                    used[s.charAt(start)] = false;
                    start++;
                }
                start++;
            }
            else{
                used[s.charAt(i)] = true;
            }
            rst = Math.max(rst, i - start+1);
        }
        return rst;
    }
}