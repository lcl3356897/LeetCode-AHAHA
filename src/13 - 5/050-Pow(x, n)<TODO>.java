//Divede & Conquer
public class Solution {
    public double myPow(double x, int n) {
    	if(n>=0)
            return helper(x,n);
        else
            return 1/helper(x,-n);
    }
    public double helper(double x, int n){
    	if(n==0) return 1; // base case
        double rst = helper(x, n/2);
        rst *= rst;
        if(n % 2 == 1) rst *= x;
        return rst;
    }
}


//Iterative

public class Solution {
    public double myPow(double x, int n) {
        if(n == 0)  return 1.0;
        boolean nNeg = n < 0 ? true : false;
        n = Math.abs(n);
        boolean xNeg = x < 0 ? true : false;
        x = Math.abs(x);
        boolean rstNeg = xNeg && n % 2 != 0 ? true : false;
        double rst = 1.0, curBase = x;
        for(int bit = 0; bit <= 31; bit++) {
            if((n>>bit & 1) == 1)
                rst *= curBase;
            curBase *= curBase;
        }
        rst = nNeg ? 1.0 / rst : rst;
        return rstNeg ? 0 - rst : rst;
    }
}