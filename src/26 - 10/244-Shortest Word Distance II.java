public class WordDistance {
	HashMap<String, List<Integer>> hm;
	List<String> list;
	
    public WordDistance(String[] words) {
    	hm = new HashMap<String, List<Integer>>();
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
    }

    public int shortest(String word1, String word2) {
    	int rst = Integer.MAX_VALUE;
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