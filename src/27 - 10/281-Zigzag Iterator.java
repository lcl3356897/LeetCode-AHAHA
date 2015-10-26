
//用Iterator
public class ZigzagIterator {
    List<Iterator<Integer> > iters = new ArrayList<Iterator<Integer> >(); 
    
    int cur = 0;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        if( !v1.isEmpty() ) iters.add(v1.iterator());
        if( !v2.isEmpty() ) iters.add(v2.iterator());
    }

    public int next() {
        int num = iters.get(cur).next();
        
        if(!iters.get(cur).hasNext()) iters.remove(cur);
        else cur++;
        
        if(iters.size()!=0) cur %= iters.size();
        
        return num;
    }

    public boolean hasNext() {
        return !iters.isEmpty();
    }
}

//用List
public class ZigzagIterator {
	private Queue<Integer> q;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        q = new LinkedList<Integer>();
        int i = 0;
        for(; i < v1.size() && i < v2.size(); i++){
        	q.add(v1.get(i));
        	q.add(v2.get(i));
        }
        if(i == v1.size()){
        	while(i < v2.size()) q.add(v2.get(i++));
        }
        else{
        	while(i < v1.size()) q.add(v1.get(i++));
        }
    }

    public int next() {
        return q.poll();
    }

    public boolean hasNext() {
        return !q.isEmpty();
    }
}
