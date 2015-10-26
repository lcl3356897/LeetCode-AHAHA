public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> rst = new ArrayList<String>();
        char[] arr = s.toCharArray();
        for(int i = 0; i < s.length() - 1; i++){
            if(arr[i] == '+' && arr[i+1] == '+'){
                arr[i] = '-'; arr[i+1] = '-';
                rst.add(new String(arr));
                arr[i] = '+'; arr[i+1] = '+';
            }
        }
        return rst;
    }
}