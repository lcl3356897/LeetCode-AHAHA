public class Solution {
    public String alienOrder(String[] words) {
        if(words == null || words.length == 0) return "";
        
        Set<Character> set = getSet(words);   
        
        List<char[]> order = getOrder(words);
        if(order.size() == 0) return words[0];     
        
        Map<Character, Integer> in = getGraph(order);
        
        return visitGraph(set, order, in);
    }
    
    private Set<Character> getSet(String[] words){
        Set<Character> set = new HashSet<Character>();
        for(String str : words){
            for(char c : str.toCharArray()){
                set.add(c);
            }
        }
        return set;
    }
    
    private List<char[]> getOrder(String[] words){
        List<char[]> order = new ArrayList<char[]>();
        for(int i = 0; i < words.length - 1; i++){
            String cur = words[i];
            String next = words[i+1];
            for(int j = 0; j < cur.length() && j < next.length(); j++){
                if(cur.charAt(j) == next.charAt(j)) continue;
                char[] tmp = {cur.charAt(j), next.charAt(j)};
                order.add(tmp);
                break;
            }
        }
        return order;
    }
    
    private Map<Character, Integer> getGraph(List<char[]> order){
        HashMap<Character, Integer> in = new HashMap<Character, Integer>();
        for(int i = 0; i < order.size(); i++){
            char c = order.get(i)[1];
            if(in.containsKey(c)){
                in.put(c, in.get(c) + 1);
            }
            else{
                in.put(c, 1);
            }
        }
        return in;
    }
    
    private String visitGraph(Set<Character> set, List<char[]> order, Map<Character, Integer> in){
        Queue<Character> q = new LinkedList<Character>();
        for(char c : set){
            if(!in.containsKey(c)) q.add(c);
        }
        
        int noPre = q.size();
        StringBuffer rst = new StringBuffer();
        
        while(!q.isEmpty()){
            char cur = q.poll();
            rst.append(cur);
            for(int i = 0; i < order.size(); i++){
                char[] tmp = order.get(i);
                if(tmp[0] == cur){
                    in.put(tmp[1], in.get(tmp[1]) - 1);
                    if(in.get(tmp[1]) == 0){
                        noPre++;
                        q.add(tmp[1]);
                    }
                }
            }
        }
        
        return noPre == set.size() ? rst.toString() : "";
    }
}