public class Solution {
    public String getPermutation(int n, int k) {
        if(n < 1 || n > 9) return "";
        StringBuffer rst = new StringBuffer("");
        
        int[] fac = new int[10];
        fac[0] = 1; fac[1] = 1;
        for(int i = 2; i <= n; i++){
            fac[i] = i * fac[i - 1];
        }

        List<Integer> nums = new ArrayList<Integer>();
        for(int i = 1; i <= n; i++){
            nums.add(i);
        }

        for(int i = n; i > 0; i--){
            int index = (k - 1) / fac[i - 1];
            k -= index * fac[i - 1];
            rst.append(nums.get(index));
            nums.remove(nums.get(index));
        }

        return rst.toString();
    }
}