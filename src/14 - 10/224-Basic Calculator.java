public class Solution {
    Stack<Character> op = new Stack<Character>();
    Stack<Integer> num = new Stack<Integer>();
    
    public int calculate(String s) {
        if(s == null || s.length() == 0) return 0;
        for(int i=0;i<s.length();i++){
        	if(s.charAt(i) == ' '){
        		continue;
        	}
        	else if('0' <= s.charAt(i) && s.charAt(i) <= '9'){
        		int j=i+1;
        		while(j<s.length() && '0' <= s.charAt(j) && s.charAt(j) <= '9'){
        			j++;
        		}
        		String tmp = s.substring(i, j);
        		num.add(Integer.parseInt(tmp));
        		i = j-1;
        		getVal();
        	}
        	else{
        		switch(s.charAt(i)){
        		case '(' : op.add('(');break;
        		case '+' : op.add('+');break;
        		case '-' : op.add('-');break;
        		case ')' : 
        			while(op.peek() != '('){
        				num.add(cal(num.pop(), num.pop(), op.pop()));
        			}
        			op.pop();
        			getVal();
        		}
        	}
        }
        getVal();
        return num.pop();
    }
    
    private void getVal(){
        while(!op.isEmpty() && op.peek() != '(' && num.size() > 1){
        	num.add(cal(num.pop(), num.pop(), op.pop()));
        }
    }
    
    private int cal(int a, int b, char c){
    	switch(c){
    	case '+' : return b+a;
    	case '-' : return b-a;
    	default : return 0;
    	}
    }
}