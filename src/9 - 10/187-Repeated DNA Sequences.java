public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> rst = new ArrayList<String>();
        if(s == null || s.length() <= 10) return rst;

        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i <= s.length() - 10; i++){
            String str = s.substring(i, i + 10);
            int code = code(str);
            if(set.contains(code) && !rst.contains(str)) rst.add(str);
            set.add(code);
        }

        return rst;
    }

    private int code(String str){
        int code = 0;
        for(int i = 0; i < str.length(); i++){
            code = code << 2 | IntegerToChar(str.charAt(i));
        }
        return code;
    }

    private int IntegerToChar(char c){
        switch(c){
            case 'A' : return 0; 
            case 'C' : return 1;
            case 'G' : return 2;
            case 'T' : return 3;
            default : return 0;
        }
    }
}