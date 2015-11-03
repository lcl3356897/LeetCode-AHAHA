public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false;

        boolean[][] matched = new boolean[s1.length() + 1][s2.length() + 1];
        matched[0][0] = true;
        for(int i = 1; i <= s1.length(); i++){
            if(s1.charAt(i - 1) == s3.charAt(i - 1)){
                matched[i][0] = true;
            }
            else break;
        }
        for(int i = 1; i <= s2.length(); i++){
            if(s2.charAt(i - 1) == s3.charAt(i - 1)){
                matched[0][i] = true;
            }
            else break;
        }

        for(int i1 = 1; i1 <= s1.length(); i1++){
            for(int i2 = 1; i2 <= s2.length(); i2++){
                int i3 = i1 + i2;
                char c1 = s1.charAt(i1 - 1), c2 = s2.charAt(i2 - 1), c3 = s3.charAt(i3 - 1);
                matched[i1][i2] |= c1 == c3 && matched[i1 - 1][i2] || c2 == c3 && matched[i1][i2 - 1];
            }
        }

        return matched[s1.length()][s2.length()];
    }
}