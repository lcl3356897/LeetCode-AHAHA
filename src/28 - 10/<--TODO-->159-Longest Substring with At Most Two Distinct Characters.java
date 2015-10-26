public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
    	if(s == null || s.length() == 0) return 0;
    	if(s.length() <= 2) return s.length();
        Set<Character> set = new HashSet<Character>();
        int i = 0, start = 0;
        while(i < s.length() && (set.size() < 2 || set.contains(s.charAt(i)))){
        	set.add(s.charAt(i++));
        }
        int rst = i;
        while(i < s.length()){
        	if(!set.contains(s.charAt(i))){
        		while(set.size() >= 2 && start < i){
        			if(set.contains(s.charAt(start)) && s.substring(start + 1, i).indexOf(s.charAt(start)) == -1){
        				set.remove(s.charAt(start));
        			}
    				start++;
        		}
        		set.add(s.charAt(i));
        	}
    		rst = Math.max(rst, i - start + 1);
        	i++;
        }
        return rst;
    }
}