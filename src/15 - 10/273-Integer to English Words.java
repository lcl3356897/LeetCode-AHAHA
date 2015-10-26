public class Solution {
    
    String[] map1 = new String [] {"", " One", " Two", " Three", " Four", " Five", " Six", " Seven", " Eight", " Nine", " Ten", 
                                        " Eleven", " Twelve", " Thirteen", " Fourteen", " Fifteen", " Sixteen", " Seventeen", " Eighteen", " Nineteen" };
            
    String[] map2 = new String[] {"", "", " Twenty", " Thirty", " Forty", " Fifty", " Sixty", " Seventy", " Eighty", " Ninety" };
        
    String[] map3 = new String[] {"", " Thousand", " Million", " Billion" };
    
    final String HUNDRED = " Hundred";
    
    public String threeDigitToWords(int num){
        String result = "";
        if (num > 99){
            result = map1[num / 100] + HUNDRED;
        }
        num %= 100;
        if(num < 20){
            result +=  map1[num];
        }else {
            result += map2[num/10] + map1[num%10];
        }
        return result;
    }
    
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        String result = "";
        
        int i = 0; //check if it is thousand, million, billion
        while(num != 0){
            if(num % 1000 != 0)
                result = threeDigitToWords(num % 1000) + map3[i] + result;
            i++;
            num /= 1000;
        }
        return result.trim();
    }
}