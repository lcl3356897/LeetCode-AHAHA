public class Solution {
	private List<Integer> qCol = new ArrayList<Integer>();
	private int rst = 0;
	
	public int totalNQueens(int n) {
		solve(n, 0);
		return rst;
	}
	
	private void solve(int n, int row){
		if(row == n){
			rst++;
			return;
		}
		
		for(int col=0;col<n;col++){
			if(valid(row, col)){
				qCol.add(col);
				solve(n, row+1);
				qCol.remove(qCol.size() - 1);
			}
		}
	}
	
	private boolean valid(int row, int col){
		if(row < qCol.size()) return false;
		for(int i=0;i<qCol.size();i++){
			if(col == qCol.get(i) || Math.abs(row - i) == Math.abs(col - qCol.get(i))){
				return false;
			}
		}
		return true;
	}
}