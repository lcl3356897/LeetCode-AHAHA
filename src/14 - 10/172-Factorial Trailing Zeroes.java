public class Solution {
    public int trailingZeroes(int n) {
        if(n <= 0){ return 0;}
        int rst = 0;
        for(long i=5;i<=n;i*=5){
        	rst += n / i;
        }
        return rst;
    }
}