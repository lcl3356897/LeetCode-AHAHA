public class Solution {
    public boolean isStrobogrammatic(String num) {
        if(num == null || num.length() == 0) return true;
        int left = 0, right = num.length() - 1;
        while(left <= right){
        	char cl = num.charAt(left);
        	char cr = num.charAt(right);
        	if(left == right){
        		return cl == '0' || cl == '1' || cl == '8';
        	}
        	switch(cl){
        	    case '0' : if(cr != '0') return false; break;
        	    case '1' : if(cr != '1') return false; break;
        	    case '6' : if(cr != '9') return false; break;
        	    case '8' : if(cr != '8') return false; break;
        	    case '9' : if(cr != '6') return false; break;
        	    default : return false;
        	}
        	left++;right--;
        }
        return true;
    }
}