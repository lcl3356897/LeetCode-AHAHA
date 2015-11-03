public class Solution {
    public int numDistinct(String s, String t) {
        // array creation
        int m = s.length(), n = t.length();
        int[][] dp = new int[m + 1][n + 1];

        // filling the first row: with 1s
        for(int i = 0; i <= m; i++){
            dp[i][0] = 1;
        }
        
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                dp[i][j] = dp[i - 1][j];
                if(s.charAt(i - 1) == t.charAt(j - 1)){
                    dp[i][j] += dp[i - 1][j - 1];
                }
                System.out.println(s.charAt(i - 1)+ "  " + t.charAt(j - 1));
                printTwoDArr(dp, s, t);
                System.out.println();
            }
        }
        
        return dp[m][n];
    }
    /*
    private void printTwoDArr(int[][] arr, String s, String t){
        s = " " + s; t = " " + t;
        System.out.print("   ");
        for(int j = 0; j < t.length(); j++){
            System.out.print(t.charAt(j) + "  ");
        }
        System.out.println();
        for(int i = 0; i < arr.length; i++){
            System.out.print(s.charAt(i) + "  ");
            for(int j = 0; j < arr[i].length; j++){
                    System.out.print(arr[i][j] + "  ");
            }
            System.out.println();
        }
    }
    */
}