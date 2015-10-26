public class Solution {
    public String reverseWords(String s) {
        if(s == null || s.length() == 0){
        	return "";
        }
        String[] arr = s.trim().split(" ");
        StringBuffer rst = new StringBuffer();
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i].length() == 0){
                continue;
            }
        	rst.append(arr[i] + " ");
        }
        if(rst.length() != 0){
            rst.deleteCharAt(rst.length() - 1);
        }
        return rst.toString();
    }
}