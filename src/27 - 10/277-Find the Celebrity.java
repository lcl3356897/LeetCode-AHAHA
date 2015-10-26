//
public class Solution extends Relation {
    public int findCelebrity(int n) {
        int l = 0, r = n - 1;
        while (l < r) {
            if (knows(l, r)) ++l;
            else --r;
        }
        for (int i = 0; i < n; ++i) if (i != l) {
            if (knows(l, i) || !knows(i, l)) return -1;
        }
        return l;
    }
}

//
public class Solution extends Relation {
    public int findCelebrity(int n) {
        if(n <= 1) return n;
        int candidate = 0;
        for(int i = 1; i < n; i++){
            if(!knows(i, candidate) || knows(candidate, i)){
                 candidate = i;
            }
        }
        for(int i = 0; i < candidate; i++){
            if(!knows(i, candidate) || knows(candidate, i)){
                return -1;
            }
        }
        return candidate;
    }
}


//

public class Solution extends Relation {
    public int findCelebrity(int n) {
    	Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 0; i < n; i++){
        	q.add(i);
        }
        while(q.size() > 1){
        	int a = q.poll();
        	int b = q.poll();
        	if(knows(a, b)){
        		q.add(b);
        	}
        	else{
        		q.add(a);
        	}
        }
        int rst = q.poll();
        for(int i = 0; i < n; i++){
        	if(i != rst && (knows(rst, i) || !knows(i, rst))){
        		return -1;
        	}
        }
        return rst;
    }
}