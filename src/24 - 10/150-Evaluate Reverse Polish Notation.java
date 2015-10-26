public class Solution {
	Stack<Character> op = new Stack<Character>();
	Stack<Integer> num = new Stack<Integer>();
	
    public int evalRPN(String[] tokens) {
    	if(tokens == null || tokens.length == 0) return 0;
    	for(String str : tokens){
    		if(str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")){
    			op.add(str.charAt(0));
    			getVal();
    		}
    		else{
    			num.add(Integer.parseInt(str));
    		}
    	}
    	return num.pop();
    }
    
    private void getVal(){
    	int b = num.pop();
    	int a = num.pop();
    	switch(op.pop()){
    		case '+' : num.add(a + b);break;
    		case '-' : num.add(a - b);break;
    		case '*' : num.add(a * b);break;
    		case '/' : num.add(a / b);break;
    	}
    }
}