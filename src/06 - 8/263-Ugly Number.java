public class Solution {
    public boolean isUgly(int num) {
        int[] divisor = {2,3,5};
        for(int i=0;i<3;i++){
            while(num % divisor[i] == 0 && num != 0){
                num /= divisor[i];
            }
        }
        return num == 1;
    }
}

//
public class Solution {
    public boolean isUgly(int num) {
        if(num <= 0){return false;}
        if(num == 1){return true;}
        int tmp = helper(num, 2);
        if(tmp == 1){return true;}
		int tmp = helper(num, 3);
        if(tmp == 1){return true;}
        int tmp = helper(num, 5);
        if(tmp == 1){return true;}
        return false;
    }

    public int helper(int num, int divisor){
    	while(num % divisor == 0){
    		num /= divisor;
    	}
    	return num;
    }
}

//
public class Solution {
    public boolean isUgly(int num) {
        if(num <= 0){return false;}
        if(num == 1){return true;}
        int[] divisor = {2,3,5};
        for(int i=0;i<3;i++){
        	while(num % divisor[i] == 0){
        		num = num / divisor[i];
        	}
        }
        return num == 1;
    }
}
