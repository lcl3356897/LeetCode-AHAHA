public class Solution {
    public List<List<Integer>> generate(int numRows) {
    	List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if(numsRow <= 0){
        	return rst;
        }
        List<Integer> row = new ArrayList<Integer>();
        row.add(1);
        rst.add(new ArrayList(row));
        if（numRows == 1){
			return rst;
		}
		row.add(1);
        rst.add(new ArrayList(row));
        if（numRows == 2){
			return rst;
		}
        for(int i=2;i<numRows;i++){
        	row.clear();
        	row.add(1);
        	for(int j=1;j<i;i++){
        		row.add( rst.get(i-1).get(j-1) + rst.get(i-1).get(j) );
        	}
        	row.add(1);
        	rst.add(new ArrayList(row));
        }
        return rst;
    }
}