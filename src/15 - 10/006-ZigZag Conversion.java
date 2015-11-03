public class Solution {
    public String convert(String s, int numRows) {
        if(s == null || s.length() == 0){
        	return "";
        }
        if(numRows == 1){
        	return s;
        }
        int n = numRows;
        ArrayList<StringBuffer> tmp = new ArrayList<StringBuffer>();
        for(int i=0;i<n;i++){
        	tmp.add(new StringBuffer());
        }
        int line = 0;
        for(int i=0;i<s.length();){
        	while(line < n && i<s.length()){
        		tmp.get(line++).append(s.charAt(i++));
        	}
        	line = n-2;
        	while(line > 0 && i<s.length()){
        		tmp.get(line--).append(s.charAt(i++));
        	}
        }	
        StringBuffer rst = new StringBuffer();
        for(int i=0;i<n;i++){
        	rst.append(tmp.get(i));
        }
        return rst.toString();
    }
}

//Math

public class Solution {
	public String convert(String s, int nRows) {  
        if(s == null || s.length()==0 || nRows <=0) return "";  
        if(nRows == 1) return s;
            
        StringBuilder rst = new StringBuilder();  
        int size = 2 * nRows - 2;  
        for(int i = 0; i < nRows; i++){  
            for(int j = i; j < s.length(); j += size){  
                rst.append(s.charAt(j));  
                //mid char
                if(i != 0 && i != nRows - 1){//except the first row and the last row
                    int temp = j + size - 2 * i;
                    if(temp < s.length())
                        rst.append(s.charAt(temp));
                }
            }                  
        }  
        return rst.toString();  
    }
}