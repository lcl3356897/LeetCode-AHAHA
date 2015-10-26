public class Solution {
	List<String> rst = new ArrayList<String>();
	char[] pair1 = {'0', '1', '8', '6', '9'};
	char[] pair2 = {'0', '1', '8', '9', '6'};
    
	public List<String> findStrobogrammatic(int n) {
        if(n == 0) return rst;
        StringBuffer path = new StringBuffer();
        if( n % 2 == 1){
        	for(int i=0;i<3;i++){
        		path.append(pair1[i]);
        		helper(n - 1, path);
        		path.deleteCharAt(path.length() - 1);
        	}
        }
        else{
        	helper(n, path);
        }
        return rst;
    }
    
    private void helper(int n, StringBuffer path){
    	if(n == 0){
    		if(path.length() == 1 || path.charAt(0) != '0') rst.add(new String(path));
    		return;
    	}
    	
    	for(int i = 0; i < 5; i++){
    		path.insert(0, pair1[i]);path.append(pair2[i]);
    		helper(n - 2, path);
    		path.deleteCharAt(0);path.deleteCharAt(path.length() - 1);
    	}
    }
}