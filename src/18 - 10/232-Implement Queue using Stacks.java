class MyQueue {
	Stack<Integer> in = new Stack<Integer>();
	Stack<Integer> out = new Stack<Integer>();
    // Push element x to the back of queue.
    public void push(int x) {
        in.add(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
    	this.peek();
        out.pop();
    }

    // Get the front element.
    public int peek() {
        if(out.isEmpty()){
        	while(!in.isEmpty()){
        		out.add(in.pop());
        	}
        }
        return out.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
}