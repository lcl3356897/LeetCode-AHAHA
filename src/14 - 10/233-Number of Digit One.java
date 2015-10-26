public class Solution {
    public int countDigitOne(int n) {
        int rst = 0;
        for (long m = 1; m <= n; m *= 10) {
            long a = n / m, b = n % m;
            rst += (a + 8) / 10 * m;
            if(a % 10 == 1) rst += b + 1;
        }
        return rst;
    }
}r