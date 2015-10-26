public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        /*
        Normal Way
        int rst = 0;
        while(n > 0){
            n &= (n-1);
            rst++;
        }
        return rst;

        However, this doesn't pass Integer.MAX_VALUE + 1
        */
        if (n == 0) {
            return 0;
        }
        
        int count = 1;
        while ((n & (n - 1)) != 0) {
            n &= n-1;
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