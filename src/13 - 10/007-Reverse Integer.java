public class Solution {
    public int reverse(int x) {
        long rst = 0;
        boolean neg = false;
        if(x < 0){
            neg = true;
            x = -x;
        }
        while(x > 0){
            rst = rst*10 + x%10;
            x /= 10;
        }
        return (int) (rst > Integer.MAX_VALUE ? 0 : (neg ? -rst : rst));
    }
}