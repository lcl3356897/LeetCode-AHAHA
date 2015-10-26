public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
        	return "";
        }
        StringBuffer rst = new StringBuffer();
        for(int i=0;i<strs[0].length;i++){
        	for(int k=1;k<strs.length;k++){
        		if(i >= strs[k].length() || strs[k].charAt(i) != strs[0].charAt(i)){
        			return rst.toString();
        		}
        	}
        	rst.add(strs[0].charAt(i));
        }
        return rst.toString();
    }
}