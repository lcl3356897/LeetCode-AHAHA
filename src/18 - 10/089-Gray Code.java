public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> rst = new ArrayList<Integer>();
        rst.add(0);
        for(int i=0;i<n;i++){
        	int high =  1 << i;
        	for(int j = rst.size()-1;j>=0;j--){
        		rst.add(high + rst.get(j));
        	}
        }
        return rst;
    }
}


//

public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> rst = new ArrayList<Integer>();
        int size = 1 << n;
        for(int i=0;i<size;i++){
        	rst.add( (i >> 1) ^ i );
        }
        return rst;
    }
}
