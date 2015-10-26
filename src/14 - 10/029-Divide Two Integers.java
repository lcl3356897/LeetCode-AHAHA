public class Solution {
	public int divide(int dividend, int divisor) {
	    if(divisor == 0) return Integer.MAX_VALUE;
	    if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;

	    boolean neg = (dividend < 0) ^ (divisor < 0);

	    long dd = Math.abs((long)dividend);
	    long dr = Math.abs((long)divisor);

	    int rst = 0;
	    while(dd >= dr){
	    	int shift = 0;
	    	while(dd >= (dr << shift)){
	    		shift++;
	    	}

	    	rst += 1 << (shift - 1);
	    	dd -= dr << (shift - 1);
	    }
	    return neg ? -rst : rst;
	}
}