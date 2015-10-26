public class Solution {
    List<String> rst = new ArrayList<String>();
    StringBuffer path = new StringBuffer();
    
    public List<String> generateParenthesis(int n) {
        if(n <= 0) return rst;
        helper(n, n);
        return rst;
    }

    private void helper(int left, int right){
        if(left > right || left < 0 || right < 0) return;
        if(left == 0 && right == 0){
            rst.add(new String(path));
            return;
        }

        path.append('(');
        helper(left - 1, right);
        path.deleteCharAt(path.length() - 1);
        path.append(')');
        helper(left, right - 1);
        path.deleteCharAt(path.length() - 1);
    }
}