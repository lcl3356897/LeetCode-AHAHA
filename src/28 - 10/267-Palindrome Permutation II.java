public class Solution {
	public List<String> generatePalindromes(String s) {
        List<String> rst = new ArrayList<String>();
        StringBuffer path = new StringBuffer();
        
		Map<Character, Integer> hm = new HashMap<Character, Integer>();
        for(char c : s.toCharArray()){
        	if(hm.containsKey(c)) hm.put(c, hm.get(c) + 1);
        	else hm.put(c, 1);
        }
        
        for(char c : hm.keySet()){
        	if(hm.get(c) % 2 == 1){
        		path.append(c);
        		hm.put(c, hm.get(c) - 1);
        	}
        	if(hm.containsKey(c)) hm.put(c, hm.get(c) / 2);
        }
        if(path.length() > 1) return rst;
        helper(rst, path, hm, s.length());
        return rst;
    }
	
	private void helper(List<String> rst, StringBuffer path, Map<Character, Integer> hm, int len){
		if(path.length() == len){
			rst.add(new String(path));
			return;
		}
		
		for(char c : hm.keySet()){
			if(hm.get(c) == 0) continue;
			path.append(c);
			path.insert(0, c);
			hm.put(c, hm.get(c) - 1);
			
			helper(rst, path, hm, len);
			
			path.deleteCharAt(0);
			path.deleteCharAt(path.length() - 1);
			hm.put(c, hm.get(c) + 1);
		}
	}
}