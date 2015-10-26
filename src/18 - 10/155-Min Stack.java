class MinStack {
    Stack<Integer> st = new Stack<Integer>();
    Stack<Integer> min = new Stack<Integer>();
    
    public void push(int x) {
        st.add(x);
        if(min.isEmpty() || min.peek() >= x){
        	min.add(x);
        }
    }

    public void pop() {
        if(min.peek().equals(st.pop())){
        	min.pop();
        }
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return min.peek();
    }
}