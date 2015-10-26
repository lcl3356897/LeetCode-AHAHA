public class Solution {
    public int numTrees(int n) {
        int[] rst = new int[n+1];
        rst[0] = 1;
        for(int i=1;i<=n;i++){
        	for(int j=0;j<i;j++){
        		rst[i] += rst[j] * rst[i-j-1];
        	}
        }
        return rst[n];
    }
}