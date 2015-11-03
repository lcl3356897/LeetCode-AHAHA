public class Solution {
	public String countAndSay(int n) {
        if(n < 0){return "";}
        String rst = "1";
        for(int i = 1; i < n; i++){
        	rst = say(rst);
        }
        return rst;
    }
	
	private String say(String s){
        StringBuffer rst = new StringBuffer();
		for(int i = 0; i < s.length();){
        	int j;
        	for(j = i; j < s.length() && s.charAt(j) == s.charAt(i);j++);
        	rst.append(j - i);
        	rst.append(s.charAt(i));
        	i = j;
        }
		return rst.toString();
	}
}