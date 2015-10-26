public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int p1 = -1, p2 = -1, rst = words.length - 1;
        for(int i = 0; i < words.length; i++){
            if(words[i].equals(word1)) p1 = i;
            if(words[i].equals(word2)) p2 = i;
            
            if(p1 != -1 && p2 != -1){
                rst = Math.min(rst, Math.abs(p1 - p2));
            }
        }
        
        return rst;
    }
}

//

public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        HashMap<String , List<Integer>> hm = new HashMap<String, List<Integer>>();
        for(int i = 0; i < words.length; i++){
        	String str = words[i];
        	if(hm.containsKey(str)){
        		hm.get(str).add(i);
        	}
        	else{
        		List<Integer> list = new ArrayList<Integer>();
        		list.add(i);
        		hm.put(str, list);
        	}
        }
        
        int rst = words.length - 1;
        int i = 0, j = 0;
        while(i < hm.get(word1).size() && j < hm.get(word2).size()){
        	int p1 = hm.get(word1).get(i), p2 = hm.get(word2).get(j);
        	if(p1 == p2) continue;
        	rst = Math.min(rst, Math.abs(p1 - p2));
        	if(p1 < p2) i++;
        	else j++;
        }
        
        return rst;
    }
}