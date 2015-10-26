//DFS

public class Solution {
    public void wallsAndGates(int[][] rooms) {
        if(rooms==null || rooms.length==0 || rooms[0]==null || rooms[0].length==0) return;
        
        boolean[][] visited = new boolean[rooms.length][rooms[0].length];
        
        for(int i = 0; i < rooms.length; i++) {
            for(int j = 0; j < rooms[0].length; j++) {
                if(rooms[i][j] == Integer.MAX_VALUE) {
                    rooms[i][j] = search(rooms, visited, i, j);
                }
            }
        }
        return;
    }
    
    private int search(int[][] rooms, boolean[][] visited, int i, int j) {
        if(i < 0 || i >= rooms.length || j < 0 || j >= rooms[0].length) return Integer.MAX_VALUE;
        if(rooms[i][j] == -1) return Integer.MAX_VALUE; 
        if(rooms[i][j]==0) return 0;
        if(visited[i][j]) return rooms[i][j];
        
        visited[i][j] = true;
        
        if(rooms[i][j]>0 && rooms[i][j]<Integer.MAX_VALUE) return rooms[i][j];
        
        int up = search(rooms, visited, i-1, j);
        int down = search(rooms, visited, i+1, j);
        int left = search(rooms, visited, i, j-1);
        int right = search(rooms, visited, i, j+1);
        
        visited[i][j] = false;
        
        int min = Math.min( Math.min(up, down), Math.min(left, right) );
        return min==Integer.MAX_VALUE ? min : min+1;
    }
}

//BFS

public class Solution {
    public void wallsAndGates(int[][] rooms) {
        LinkedList<int[]> list = new LinkedList<int[]>();
        for(int i = 0; i < rooms.length; i++) {
            for(int j = 0; j < rooms[0].length; j++) {
                if(rooms[i][j] == 0) 
                    list.add(new int[]{i,j});
            }
        }
        
        int[][] diff = new int[][]{{-1, 0, 1, 0},{0, 1, 0, -1}};
        while(!list.isEmpty()) {
            int[] pop = list.remove();
            for(int i = 0; i < diff[0].length; i++) {
                int x = pop[0] + diff[0][i];
                int y = pop[1] + diff[1][i];
                if(x < 0 || x >= rooms.length || y < 0 || y >= rooms[0].length || 
                   rooms[x][y] != Integer.MAX_VALUE) 
                    continue;
                rooms[x][y] = rooms[pop[0]][pop[1]] + 1;
                list.add(new int[]{x, y});
            }
        }
    }
}