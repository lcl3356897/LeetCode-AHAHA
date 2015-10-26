public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(prerequisites == null){
            throw new IllegalArgumentException("illegal prerequisites array");
        }
        
        int[] rst = new int[numCourses];
        int len = prerequisites.length;
        
        if(len == 0){
            for(int i=0;i<numCourses;i++){
                 rst[i] = i;
            }
            return rst;
        }
        
        int[] in = new int[numCourses];
        for(int i=0;i<len;i++){
            in[prerequisites[i][0]]++;
        }
        
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i=0;i<numCourses;i++){
            if(in[i] == 0) q.add(i);
        }
        
        int noPre = q.size();
        int j = 0;
        
        while(!q.isEmpty()){
            int cur = q.poll();
            rst[j++] = cur;
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
        
        return noPre == numCourses ? rst : new int[0];
    }
}