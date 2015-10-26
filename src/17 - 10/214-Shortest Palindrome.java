public class Solution {
    public String shortestPalindrome(String s) {
        StringBuffer sb = new StringBuffer();
        String rev = new StringBuffer(s).reverse().toString();
        sb.append(s).append("#").append(rev);
        int[] next = new int[sb.length()];
        for(int i=1;i<next.length;i++){
            int j = next[i-1];
            while(j > 0 && sb.charAt(i) != sb.charAt(j)){
                j = next[j-1];
            }
            next[i] = j == 0 ? ( sb.charAt(i) == sb.charAt(0) ? 1 : 0) : j+1;
        }

        return rev.substring(0, rev.length() - next[next.length - 1]) + s;
    }
}