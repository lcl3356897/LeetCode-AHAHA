public class Solution {
    public int factor(int n){
        if(n == 1 || n == 0){
            return 1;
        }
        return n*factor(n-1);
    }
    public String getPermutation(int n, int k) {
        StringBuffer rst = new StringBuffer("");
        if(n < 1 || n > 9){
            return rst.toString();
        }
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for(int i=0;i<n;i++){
            nums.add(i+1);
        }
        int rest = k;
        for(int i=n;i>0;i--){
            int index = (rest - 1) / factor(i-1);
            rest -= index * factor(i-1);
            rst.append(nums.get(index));
            nums.remove(nums.get(index));
        }
        return rst.toString();
    }
}