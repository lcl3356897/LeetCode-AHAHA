public class Solution {
    public String addBinary(String a, String b) {
    	StringBuffer rst = new StringBuffer();
    	a = new StringBuffer(a).reverse().toString();
    	b = new StringBuffer(b).reverse().toString();
    	int carry = 0;
    	int n = Math.max(a.length(), b.length());
    	for(int i=0;i<n;i++){
    		if(i<a.length()){
    			carry += a.charAt(i) - '0';
    		}
    		if(i<b.length()){
    			carry += b.charAt(i) - '0';
    		}
    		rst.append(carry % 2);
    		carry /= 2;
    	}
    	if(carry == 1){
    		rst.append(carry);
    	}
    	return rst.reverse().toString();
    }
}