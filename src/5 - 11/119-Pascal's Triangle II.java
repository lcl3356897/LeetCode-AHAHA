public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> rst = new ArrayList<Integer>();
        for(int i=0;i<2 && i<=rowIndex;i++){
            rst.add(1);
        }
        if(rowIndex <= 1){
            return rst;
        }
        for(int i=2;i<=rowIndex;i++){
            int prev = 1;
            for(int j=1;j<i;j++){
                int tmp = rst.get(j);
                rst.set(j, rst.get(j) + prev);
                prev = tmp;
            }
            rst.add(1);
        }
        return rst;
    }
}