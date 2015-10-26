public class Solution {
    private String[] bt = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private List<String> rst = new ArrayList<String>();
    private StringBuffer path = new StringBuffer();
    
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0){
            return rst;
        }
        helper(digits, 0);
        return rst;
    }

    private void helper(String digits, int index){
        if(index == digits.length()){
            rst.add(new String(path));
            return;
        }
        if(digits.charAt(index) == '0' || digits.charAt(index) == '1') helper(digits, index + 1);

        String button = bt[digits.charAt(index) - '0'];
        for(int i = 0; i < button.length(); i++){
            path.append(button.charAt(i));
            helper(digits, index + 1);
            path.deleteCharAt(path.length() - 1);
        }
    }
}