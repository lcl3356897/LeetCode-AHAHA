class MyStack {
	Queue<Integer> q = new LinkedList<Integer>();
    // Push element x onto stack.
    public void push(int x) {
        q.add(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        for(int i=0;i<q.size()-1;i++){
        	q.add(q.poll());
        }
        q.poll();
    }

    // Get the top element.
    public int top() {
        int top = 0;
        for(int i=0;i<q.size();i++){
        	top = q.poll();
        	q.add(top);
        }
        return top;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q.isEmpty();
    }
}