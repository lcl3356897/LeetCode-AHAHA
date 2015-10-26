public class Solution {
    List<List<String>> rst = new ArrayList<List<String>>();
    List<String> sol = new ArrayList<String>();
    List<Integer> qCol = new ArrayList<Integer>();
    
    public List<List<String>> solveNQueens(int n) {
        solve(n, 0);
        return rst;
    }
    
    private void solve(int n, int row){
        if(row == n){
            rst.add(new ArrayList<String>(sol));
            return;
        }
        for(int col=0;col<n;col++){
            if(valid(row, col)){
                char[] line = new char[n];
                Arrays.fill(line, '.');
                line[col] = 'Q';
                sol.add(new String(line));
                qCol.add(col);
                solve(n, row+1);
                sol.remove(sol.size() - 1);
                qCol.remove(qCol.size() - 1);
            }
        }
    }
    
    private boolean valid(int row, int col){
        if(row < qCol.size()) return false;
        for(int i=0;i<qCol.size();i++){
            if(col == qCol.get(i) || (Math.abs(row - i) == Math.abs(col - qCol.get(i)))){
                return false;
            }
        }
        return true;
    }
}