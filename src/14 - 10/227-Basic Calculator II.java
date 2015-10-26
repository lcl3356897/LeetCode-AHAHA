public class Solution {
    public int calculate(String s) {
        int rst = 0, localRst = 0, Option = 1, localNeg = 1;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
            case ' ':continue;
            case '+':Option = 1;break;
            case '-':Option = -1;break;
            case '*':Option = 2;break;
            case '/':Option = 3;break;
            default:
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i)))
                    num = num * 10 + s.charAt(i++) - '0';
                i--;
                switch (Option) {
                case 1:
                    rst += localNeg * localRst;
                    localRst = num;
                    localNeg = 1;
                    break;
                case -1:
                    rst += localNeg * localRst;
                    localRst = num;
                    localNeg = -1;
                    break;
                case 2:
                    localRst *= num;
                    break;
                case 3:
                    localRst /= num;
                }

            }
        }
        rst += localNeg * localRst;
        return rst;
    }
}