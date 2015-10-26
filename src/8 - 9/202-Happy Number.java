public class Solution {
    public boolean isHappy(int n) {
    	if(n <= 0 ){
    		return false;
    	}
    	HashSet<Integer> hs = new HashSet<Integer>();
    	while(n != 1){
    		int tmp = helper(n);
    		if(hs.contains(tmp)){
    			return false;
    		}
    		hs.add(tmp);
    		n = tmp;
    	}
    	return n == 1;
    }
    public int helper(int n){
    	int rst = 0;
    	while(n > 0){
    		int tmp = n%10;
    		rst += tmp * tmp;
    		n /= 10;
    	}
    	return rst;
    }
}