public class Solution {
    public String multiply(String num1, String num2) {
    	char[] rst = new char[num1.length()+num2.length()];
    	for(int i = 0; i < rst.length; i++){
    		rst[i] = '0';
    	}
        for(int i = 0; i < num1.length(); i++){
        	for(int j = 0; j < num2.length(); j++){
        		int tmp = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
        		rst[i+j+1] += tmp;
        	}
        }
        int carry = 0;
        for(int i = rst.length-1; i > 0; i--){
        	if(rst[i] > '9' || carry != 0){
        		rst[i] += carry;
        		carry = (rst[i] - '0') / 10;
        		rst[i] -= 10 * carry;
        	}
        }
        if(carry != 0){
        	rst[0] += carry;
        }
        int start = rst.length-1;
        for(int i = 0; i < rst.length; i++){
        	if(rst[i] != '0'){
        		start = i;
        		break;
        	}
        }
        return new String(rst, start, rst.length-start);
    }
}