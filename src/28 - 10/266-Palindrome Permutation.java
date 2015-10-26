public class Solution {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> hm = new HashMap<Character, Integer>();
        for(char c : s.toCharArray()){
        	if(hm.containsKey(c)){
        		hm.put(c, hm.get(c) + 1);
        	}
        	else{
        		hm.put(c, 1);
        	}
        }
        int odd = 0;
        for(int val : hm.values()){
        	odd += val % 2;
        }
        
        return odd <= 1;
    }
}