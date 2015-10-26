public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int rst=0;
        for(int i=0;i<32;i++){
            rst += ((n >> i) & 1) << (31-i);
        }       
        return rst;
    }
}