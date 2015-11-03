public class Solution {
    List<List<String>> rst = new ArrayList<List<String>>();
    List<String> path = new ArrayList<String>();

    public List<List<String>> partition(String s) {
        if(s == null || s.length() == 0) return rst;

        int n = s.length();
        boolean[][] is = new boolean[n][n];
        for(int i = n - 1; i >= 0; i--){
            is[i][i] = true;
            for(int j = i + 1; j < n; j++){
                if( ((i + 1 == j) || is[i + 1][j - 1]) && s.charAt(i) == s.charAt(j) ){
                    is[i][j] = true;
                }
            }
        }

        helper(s, 0, is);
        return rst;
    }

    private void helper(String s, int start, boolean[][] is){
        if(start == s.length()){
            if(!rst.contains(path)) rst.add(new ArrayList<String>(path));
            return;
        }

        for(int i = start; i < s.length(); i++){
            if(!is[start][i]) continue;
            path.add(s.substring(start, i + 1));
            helper(s, i + 1, is);
            path.remove(path.size() - 1);
        }
    }
}