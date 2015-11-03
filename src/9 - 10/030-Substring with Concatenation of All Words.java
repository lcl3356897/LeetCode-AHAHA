public class Solution {
    public List<Integer> findSubstring(String s, String[] words){
    	List<Integer> rst = new ArrayList<Integer>();
        if(s == null || words == null || words.length == 0){
        	return rst;
        }
        int wordLength = words[0].length();
        int len = words.length * wordLength;
        if(s.length() < len){
        	return rst;
        }
        HashMap<String, Integer> all = new HashMap<String, Integer>();
        for(String w : words){
        	if(all.containsKey(w)){
        		all.put(w, all.get(w)+1);
        	}
        	else{
        		all.put(w, 1);
        	}
        }
        for(int i=0;i<=s.length() - len;i++){
        	if(helper(s, i, all, wordLength, words.length)){
        		rst.add(i);
        	}
        }
        return rst;
    }
    
    public boolean helper(String s, int start, HashMap<String, Integer> all, int wordLength, int wordsNum){
    	if(s.length()-start+1 < wordLength*wordsNum ){
    		return false;
    	}
    	HashMap<String, Integer> found = new HashMap<String, Integer>();
    	for(int i=0;i<wordsNum;i++){
    		String cur = s.substring(start+i*wordLength, start+(i+1)*wordLength);
    		if(!all.containsKey(cur)){
    			return false;
    		}
    		if(found.containsKey(cur)){
    			found.put(cur, found.get(cur)+1);
    		}
    		else{
    			found.put(cur, 1);
    		}
    		if(found.get(cur) > all.get(cur)){
    			return false;
    		}
    	}
    	return true;
    }
    
}
