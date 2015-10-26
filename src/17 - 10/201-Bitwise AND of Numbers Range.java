public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        if(m == 0 || n == 0){
        	return 0;
        }
        int shift = 0;
        while(m != n){
        	m >>= 1;
        	n >>= 1;
        	shift++;
        }
        return m << shift;
    }
}

//
public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
         while (n > m) {
              n = n & n - 1;
         }
         return m & n;
    }
}