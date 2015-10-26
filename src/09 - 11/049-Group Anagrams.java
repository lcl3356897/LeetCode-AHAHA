public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> rst = new ArrayList<List<String>>();
        if(strs == null || strs.length == 0){
        	return rst;
        }
        HashMap<String, List<String>> hm = new HashMap<String, List<String>>();
        for(String w : strs){
        	char[] arr = w.toCharArray();
        	Arrays.sort(arr);
        	String tmp = new String(arr);
        	if(hm.containsKey(tmp)){
        		hm.get(tmp).add(w);
        	}
        	else{
        		List<String> tmpList = new ArrayList<String>();
        		tmpList.add(w);
        		hm.put(tmp, tmpList);
        	}
        }
        for(List<String> list : hm.values()){
        	Collections.sort(list);
        	rst.add(list);
        }
        return rst;
    }
}