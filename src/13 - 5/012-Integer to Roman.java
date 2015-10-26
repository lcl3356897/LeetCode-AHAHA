public class Solution {
    public String intToRoman(int num) {
        if(num <= 0)  return "";
        String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuffer rst = new StringBuffer();
        for(int i = 0; i < values.length;i++){
            while(num >= values[i]){
                num -= values[i];
                rst.append(symbols[i]);
            }
        }
        return rst.toString();
    }
}