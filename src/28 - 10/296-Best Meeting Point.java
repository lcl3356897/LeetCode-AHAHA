public class Solution {
    public int minTotalDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        List<Integer> li = new ArrayList<Integer>();
        List<Integer> lj = new ArrayList<Integer>();
        for(int i = 0; i < m; i++){
        	for(int j = 0; j < n; j++){
        		if(grid[i][j] == 1){
        			li.add(i);
        			lj.add(j);
        		}
        	}
        }
        Collections.sort(lj);
        
        return getMin(li) + getMin(lj);
    }
    
    private int getMin(List<Integer> list){
    	int rst = 0;
    	int i = 0, j = list.size() - 1;
    	while(i < j){
    		rst += list.get(j--) - list.get(i++);
    	}
    	return rst;
    }
}