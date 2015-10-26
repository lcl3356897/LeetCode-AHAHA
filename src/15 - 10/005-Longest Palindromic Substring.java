public class Solution {
    public String longestPalindrome(String s) {
    	if(s == null || s.length() == 0){
    		return "";
        }
        StringBuffer tmp = new StringBuffer();
        tmp.append('#');
        for(int i = 0; i < s.length(); i++){
        	tmp.append(s.charAt(i));
        	tmp.append('#');
        }
        
        int mx = 0, id = 0;//mx the longest position could be hui, id is the center
        int max = 0, maxId = 0;
        int[] p = new int[tmp.length()];
        for(int i = 0; i < tmp.length(); i++){
        	if(mx > i){
        		p[i] = Math.min(p[2 * id - i ], mx - i);
        	}
        	else{
        		p[i] = 1;
        	}
        	while(i - p[i] >= 0 && i + p[i] < tmp.length() && tmp.charAt(i+p[i]) == tmp.charAt(i-p[i])){
        		p[i]++;
        	}
        	if(i + p[i] > mx){
        		mx = i + p[i];
        		id = i;
        	}
        	if(p[i] > max){
        		max = p[i];
        		maxId = i;
        	}
        }
        StringBuffer rst = new StringBuffer();
        for(int i = maxId - max + 1; i < maxId + max; i++){
        	if(tmp.charAt(i) != '#'){
        		rst.append(tmp.charAt(i));
        	}
        }
        return rst.toString();
    }
}