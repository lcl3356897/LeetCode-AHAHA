public class Solution {
	private List<List<String>> rst = new ArrayList<List<String>>();
	
    public List<List<String>> partition(String s) {
        if(s == null || s.length() == 0) return rst;
    	List<String> path = new ArrayList<String>();
    	int n = s.length();
    	boolean[][] is = new boolean[n][n];
    	for(int i=n-1;i>=0;i--){
    		for(int j=i;j<n;j++){
    			if(((i+1 > j-1) || is[i+1][j-1]) && s.charAt(i) == s.charAt(j)){
    				is[i][j] = true;
    			}
    		}
    	}
        helper(s, 0, is, path);
        return rst;
    }
    private void helper(String s, int start, boolean[][] is, List<String> path){
    	if(start == s.length()){
    		if(rst.indexOf(path) == -1) rst.add(new ArrayList<String>(path));
    		return;
    	}
    	
    	for(int i=start;i<s.length();i++){
    		if(is[start][i]){
    			path.add(s.substring(start, i+1));
    			helper(s, i+1, is, path);
    			path.remove( path.size() - 1);
    		}
    	}
    }
}