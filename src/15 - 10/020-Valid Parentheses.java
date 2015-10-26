public class Solution {
    public boolean isValid(String s) {
        if(s == null || s.length() == 0){
        	return true;
        }
        Stack<Character> st = new Stack<Character>();
        for(int i=0;i<s.length();i++){
        	switch(s.charAt(i)){
	        	case '(' :
	        	case '[' : 
	        	case '{' : st.push(s.charAt(i));break;
	        	case ')' : 
	        		if(st.isEmpty() || st.peek() != '('){return false;}
	        		st.pop(); break;
	        	case '}' :
	        		if(st.isEmpty() || st.peek() != '{'){return false;}
	        		st.pop(); break;
	        	case ']' :
	        		if(st.isEmpty() || st.peek() != '['){return false;}
	        		st.pop(); break;
	        	default : return false;
        	}
        }
        return st.isEmpty();
    }
}