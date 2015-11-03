public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0; 
        while(n != 0){
            n = n & (n - 1);
            count++;
        }
        return count;
    }
}

//

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int rst=0;
        for(int i=0;i<32;i++){
            int tmp;
            if((tmp = n >> i) == 0) break;
            rst += tmp & 1;
        }
        return rst;
    }
}