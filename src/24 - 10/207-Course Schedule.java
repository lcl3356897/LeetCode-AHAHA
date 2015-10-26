//BFS
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
    	if(prerequisites == null){
    		throw new IllegalArgumentException("illegal prerequisites array");
    	}
    	
    	int len = prerequisites.length;
    	if(numCourses == 0 || len == 0) return true;
    	
    	int[] in = new int[numCourses];
    	for(int i=0;i<len;i++){
    		in[prerequisites[i][0]]++;
    	}
    	
    	Queue<Integer> q = new LinkedList<Integer>();
    	for(int i=0; i<numCourses; i++){
    		if(in[i] == 0) q.add(i);
    	}
        
    	int noPre = q.size();
    	
    	while(!q.isEmpty()){
    		int cur = q.poll();
    		for(int i=0;i<len;i++){
    			if(prerequisites[i][1] == cur){
    				in[prerequisites[i][0]]--;
    				if(in[prerequisites[i][0]] == 0){
    					noPre++;
    					q.add(prerequisites[i][0]);
    				}
    			}
    		}
    	}
    	
    	return noPre == numCourses;
    }
}

//DFS
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null){
            throw new IllegalArgumentException("illegal prerequisites array");
        }
        
        int len = prerequisites.length;
        if(numCourses == 0 || len == 0) return true;
        
        //default value is 0, if visited -1, if not and checked 1
        int[] visit = new int[numCourses];
        
        HashMap<Integer,ArrayList<Integer>> hm = new HashMap<Integer,ArrayList<Integer>>();
        for(int[] a : prerequisites){
            if(hm.containsKey(a[1])){
                hm.get(a[1]).add(a[0]);
            }
            else{
                ArrayList<Integer> tmp = new ArrayList<Integer>();
                tmp.add(a[0]);
                hm.put(a[1], tmp);
            }
        }
        
        for(int i=0; i<numCourses; i++){
            if(!DFS(hm, visit, i)) return false;
        }
        
        return true;
    }
    
    private boolean DFS(HashMap<Integer,ArrayList<Integer>> hm, int[] visit, int i){
        if(visit[i] == -1) return false;
        if(visit[i] == 1) return true;
        
        visit[i] = -1;
        if(hm.containsKey(i)){
            for(int j : hm.get(i)){
                if(!DFS(hm, visit, j)) return false;
            }
        }
        visit[i] = 1;
        return true;
    }
}
