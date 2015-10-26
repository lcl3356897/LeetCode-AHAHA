public class Solution {
    public int myAtoi(String str) {
        if(str == null){
        	return 0;
        }
        str = str.trim();
        if(str.length() == 0){
        	return 0;
        }
        int rst = 0, limit = Integer.MAX_VALUE / 10;
        int i = 0;
        boolean neg = false;
        if(str.charAt(i) < '0'){
        	if(str.charAt(i) == '-'){
        		neg = true;
        		i++;
        	}
        	else if(str.charAt(i) == '+'){
        		i++;
        	}
        	else{
        		return 0;
        	}
        }
        if(i == str.length()){
        	return 0;
        }
        for(;i<str.length();i++){
        	char c = str.charAt(i);
        	if(c < '0' || c > '9'){
        		break;
        	}
        	int num = c -'0';
        	if(neg){
        		if((rst > limit) || (rst == limit && num >= 8)){
        			return Integer.MIN_VALUE;
        		}
        	}
        	else{
        		if((rst > limit) || (rst == limit && num >= 7)){
        			return Integer.MAX_VALUE;
        		}
        	}
        	rst *= 10; rst += num;
        }
        return neg ? -rst : rst;
    }
}