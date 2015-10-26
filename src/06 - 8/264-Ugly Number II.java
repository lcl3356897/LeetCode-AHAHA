public class Solution {
    public int nthUglyNumber(int n) {
        if(n <= 0) return 0;
        ArrayList<Integer> rst = new ArrayList<Integer>();
        rst.add(1);
        int p2=0, p3=0, p5=0;
        while(rst.size() < n){
            int min = Math.min(Math.min(rst.get(p2)*2, rst.get(p3)*3), rst.get(p5)*5);
            if(min == rst.get(p2)*2) p2++;
            if(min == rst.get(p3)*3) p3++;
            if(min == rst.get(p5)*5) p5++;
            rst.add(min);
        }
        return rst.get(rst.size()-1);
    }
}