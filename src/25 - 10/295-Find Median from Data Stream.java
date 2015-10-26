class MedianFinder {
	
	PriorityQueue<Integer> first = new PriorityQueue<Integer>(Collections.reverseOrder());
	PriorityQueue<Integer> second = new PriorityQueue<Integer>();
	
    // Adds a number into the data structure.
    public void addNum(int num) {
    	if(!first.isEmpty() && num < first.peek()){
    		first.add(num);
    		second.add(first.poll());
    	}
    	else{
        	second.add(num);
    	}
    	int len = first.size() + second.size();
    	if(second.size() > (len + 1) / 2){
    		first.add(second.poll());
    	}
    }

    // Returns the median of current data stream
    public double findMedian() {
        int len = first.size() + second.size();
        if(len % 2 == 0){
        	return (first.peek() + second.peek()) / 2.0;
        }
        else{
        	return 1.0 * second.peek();
        }
    }
};