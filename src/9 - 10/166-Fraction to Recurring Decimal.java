public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0){
            return "0";
        }
        if(denominator == 0){
            return "";
        }
        StringBuffer rst = new StringBuffer();
        
        // is result is negative
        if((numerator < 0) ^ (denominator < 0)){
            rst.append("-");
        }
    
        // convert int to long
        long num = numerator, den = denominator;
        num = Math.abs(num);
        den = Math.abs(den);

        // quotient (shang)
        long rest = num / den;
        rst.append(rest);

        // if remainder is 0, return result
        long reminder = num % den;
        if(reminder == 0){
            return rst.toString();
        }
        reminder *= 10;

        // if remainder is 0, return result
        HashMap<Long, Integer> hm = new HashMap<Long, Integer>();
        rst.append(".");
        while(reminder != 0){
            if(hm.containsKey(reminder)){
                rst.insert(hm.get(reminder), "(");
                rst.append(")");
                return rst.toString();
            }
            else{
                hm.put(reminder, rst.length());
                rst.append(reminder / den);
                reminder = reminder % den * 10;                
            }
        }
        return rst.toString();
    }
}