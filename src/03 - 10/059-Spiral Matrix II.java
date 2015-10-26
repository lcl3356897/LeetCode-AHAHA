public class Solution {
    public int[][] generateMatrix(int n) {
 		int[][] rst = new int[n][n];
 		if(n < 1){
 			return rst;
 		}
 		int level = n / 2;
 		int num =1;
 		for(int i=0;i<level;i++){
 			int last = n - 1 -i;
 			for(int j=i;j<last;j++){
 				rst[i][j] = num++;
 			}
 			for(int j=i;j<last;j++){
 				rst[j][last] = num++;
 			}
 			for(int j=last;j>i;j--){
 				rst[last][j] = num++;
 			}
 			for(int j=last;j>i;j--){
 				rst[j][i] = num++;
 			}
 		}       
 		if(n % 2 == 1){
 			rst[n/2][n/2] = num;
 		}
 		return rst;
    }
}