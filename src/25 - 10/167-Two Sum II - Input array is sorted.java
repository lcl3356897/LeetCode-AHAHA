public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] rst = {-1, -1};
        int left = 0, right = numbers.length - 1;
        while(left < right){
            int sum = numbers[left] + numbers[right];
            if(sum < target){
                left++;
            }
            else if(sum > target){
                right--;
            }
            else{
                rst[0] = left + 1;
                rst[1] = right + 1;
                return rst;
            }
        }
        return rst;
    }
}