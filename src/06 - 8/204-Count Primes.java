public class Solution {
    public int countPrimes(int n) {
        if(n <= 1){
        	return 0;
        }
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        for(int i=2;i*i < n;i++){
        	if(isPrime[i] == false){
        		continue;
        	}
        	for(int j=i+i;j<n;j+=i){
        		isPrime[j] = false;
        	}
        }
        int rst = 0;
        for(int i=2;i<n;i++){
        	rst += isPrime[i] ? 1 : 0;
        }
        return rst;
    }
}